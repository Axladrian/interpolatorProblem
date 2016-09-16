# interpolatorProblem - demo of android bug

Got a report that an animation isn't running right on an app I've recently done. Checked it out and it seems that on Android API 24 indeed it doesn't run as it should.

Did some debuging and found out that while creating a ReverseInterpolator for a ValueAnimator, the ValueAnimator won't reverse as I demonstrated in this repo.

This isn't the case for other Android API <24 devices.

Tested on: 
  Nexus 6P (android 7.0)
  Nexus 5X (android 7.0)
  OnePlusTwo (android 6.0)
  GalaxyS4 (android 5.0)
