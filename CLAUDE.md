# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This repository contains two main areas of work:
1. **DSA Practice** - Data Structures and Algorithms solutions (secondary)
2. **IBM Project** - Time series analysis and traffic forecasting research (primary focus)

## Repository Structure

```
.
├── *.java, *.cpp, *.py          # DSA problem solutions (100+ problems)
├── .venv/                        # Python 3.13.7 virtual environment
├── archive/                      # Archived data (housing.csv)
├── Arrays/                       # Array-related problems
├── "Harvestify Crop Health/"     # Separate project (not part of main work)
└── "IBM Project/"                 # PRIMARY WORK AREA
    ├── BasicTS/                  # Time series analysis toolkit
    └── STAEformer/               # Spatio-temporal forecasting model
```

## Primary Work Area: IBM Project

### STAEformer (Spatio-Temporal Adaptive Embedding Transformer)

**Location**: `IBM Project/STAEformer/`

**Paper**: "Spatio-Temporal Adaptive Embedding Makes Vanilla Transformer SOTA for Traffic Forecasting" (CIKM 2023)

**Key Files**:
- `model/train.py` - Training script
- `train_modified.py` - Modified training with custom configurations
- `run_ablation.py` - Ablation study experiments
- `prepare_augmented_data.py` - Data preparation
- `EXPERIMENTS.md` - Experiment documentation
- `lib/` - Library modules
- `model/` - Model architecture
- `data/` - Dataset directory
- `results/` - Output results

**Required Packages**:
```
pytorch>=1.11, numpy, pandas, matplotlib, pyyaml, pickle, torchinfo
```

### BasicTS (Basic Time Series)

**Location**: `IBM Project/BasicTS/`

**Description**: A fair and scalable time series analysis toolkit and benchmark.

**Setup**:
```powershell
cd "IBM Project/BasicTS"
pip install -e .
```

## Running STAEformer

### Training
```powershell
cd "IBM Project/STAEformer/model"
python train.py -d <dataset> -g <gpu_id>
```

### Datasets Supported
- METRLA, PEMSBAY, PEMS03, PEMS04, PEMS07, PEMS08

### Running Modified Training
```powershell
cd "IBM Project/STAEformer"
python train_modified.py [options]
```

### Running Ablation Studies
```powershell
cd "IBM Project/STAEformer"
python run_ablation.py [options]
```pip

### Activating Python Environment
```powershell
.venv\Scripts\activate
```

## Git Workflow

- Branch: `main`
- Work location: `IBM Project/STAEformer/` and `IBM Project/BasicTS/`
- Use descriptive commit messages
- Stage changes: `git add <file>`
- Commit: `git commit -m "description"`

## Common Development Tasks

### Checking Environment
```powershell
cd "IBM Project/STAEformer"
python check_env.py
```

### Preparing Data
```powershell
python prepare_augmented_data.py
```

### Running Experiments
```powershell
python run_ablation.py --config <config_file>
```

## Notes

- Primary work is in `IBM Project/STAEformer/`
- The DSA folder contains practice problems (secondary work)
- Use the virtual environment for Python work
- Check `EXPERIMENTS.md` for experiment details
- Results are saved to the `results/` directory