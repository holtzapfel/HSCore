# HSCore
by [Holtzapfel Studios](https://holtzapfel.github.io/)

### Install
1.  Add Maven Jitpack repository to _Project level_ build.gradle
```gradle
allprojects {
    repositories {
        ...
        maven { 
            url "https://jitpack.io" 
        }
    }
}
```
2.  Insert gradle dependency in _Module level_ build.gradle
```gradle
compile 'com.github.holtzapfel:HSCore:X.X.X'
```

## MenuMaker
### Introduction

Tired of creating and recreating a settings menu?  Quit spending so much time on a menu that, if done correctly, nobody notices.  Allow me to do the hard work for you.  Use **Menu Maker** in your app with ease today!  

You will never have to design a menu again.

##### Screenshots
<img src="https://github.com/holtzapfel/MenuMaker/raw/master/dev/screenshots/device-2017-06-30-112934.png" width="275"><img src="https://github.com/holtzapfel/MenuMaker/raw/master/dev/screenshots/device-2017-06-30-113659.png" width="275"><img src="https://github.com/holtzapfel/MenuMaker/raw/master/dev/screenshots/device-2017-06-30-113808.png" width="275">

##### Some Ideas for Use
- Settings Menu
- Links List
- FAQs
- User Profile Editing
- Development Credits List
- Help Section
- Display Lists of Information
- _... the possibilities are endless!_

##### Features
- Easy to use API
- Create a deep structured menu with multiple pages
- Generate true/false menu items with switches
- Enable an optional Floating Action Button
- Customizable text options
- Add icons for a unique look
- Modify menu items while in use
- Compatible with API level 15 and above

### Setup
During this migration period, the old [MenuMaker Wiki](https://github.com/holtzapfel/MenuMaker/wiki) should be used for instructions.  

**Important:** Do *not* use the repository provided at the Wiki page.  It may be outdated.
