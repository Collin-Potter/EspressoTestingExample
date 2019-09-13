# EspressoTestingExample

## Requirements tested

- Clicking the 'hide' button while in portrait mode should result in a hidden TextView
- Clicking the 'hide' button while in landscape mode should result in a hidden TextView
- Clicking the 'show' button while in portrait mode should result in a visible TextView
- Clicking the 'show' button while in landscape mode should result in a visible TextView

All previous tests were also tested with activity interruptions in the form of orientation changes to test state persistence

### Disclaimer: Although there were no specifications to check state persistence, I believe it is a good practice to have those tests implemented for future features.

### Please note: due to the simplicity of this project, I did not ensure that all environment variables are set correctly to run perfectly in Gradle from the command line
