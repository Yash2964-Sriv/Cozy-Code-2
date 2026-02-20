import cv2
import numpy as np
from tensorflow.keras.models import load_model

model = load_model("hand_gesture_cnn.h5")

# Gesture labels (same order as training folders)
gesture_labels = ['fist', 'five', 'none', 'okay', 'peace', 'rad', 'straight', 'thumbs']
IMG_SIZE = 128

gesture_meanings = {
    'fist': "✊ You showed a FIST — maybe 'stop' or 'power'.",
    'five': "🖐️ You showed FIVE fingers — open palm or 'hi'.",
    'none': "🤚 No gesture detected — try again!",
    'okay': "👌 You showed the OKAY sign — all good!",
    'peace': "✌️ You showed the PEACE sign — nice!",
    'rad': "🤙 You showed the RAD/SHAKA sign — hang loose!",
    'straight': "☝️ You pointed one finger — straight or one.",
    'thumbs': "👍 You gave a THUMBS UP — great job!"
}

cap = cv2.VideoCapture(0)
if not cap.isOpened():
    print("❌ Cannot open camera. Check your webcam connection.")
    exit()

print("🎥 Webcam started. Press ESC to exit.")

previous_gesture = None  # track previous gesture to avoid spamming console

while True:
    ret, frame = cap.read()
    if not ret:
        print("⚠️ Failed to grab frame.")
        break

    frame = cv2.flip(frame, 1)

    x1, y1, x2, y2 = 100, 100, 400, 400
    roi = frame[y1:y2, x1:x2]

    gray = cv2.cvtColor(roi, cv2.COLOR_BGR2GRAY)
    _, thresh = cv2.threshold(gray, 100, 255, cv2.THRESH_BINARY)

    img = cv2.resize(thresh, (IMG_SIZE, IMG_SIZE))
    img = np.stack((img,)*3, axis=-1)
    img = np.expand_dims(img, axis=0) / 255.0

    pred = model.predict(img)
    gesture_index = np.argmax(pred)
    gesture = gesture_labels[gesture_index]
    confidence = np.max(pred)

    cv2.rectangle(frame, (x1, y1), (x2, y2), (0, 255, 0), 2)
    text = f"{gesture} ({confidence*100:.1f}%)"
    cv2.putText(frame, text, (x1, 90), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 255), 2)

    cv2.imshow("Hand Gesture Recognition", frame)
    cv2.imshow("ROI", thresh)

    if gesture != previous_gesture and confidence > 0.85:  # only print if confident and changed
        meaning = gesture_meanings.get(gesture, "🤔 Unknown gesture.")
        print(meaning)
        previous_gesture = gesture

    # Exit on ESC key
    if cv2.waitKey(1) & 0xFF == 27:
        break

cap.release()
cv2.destroyAllWindows()
print("🛑 Webcam closed.")
