---
layout: page
title: CliniCal User Guide
---

* Table of Contents
{:toc}
--------------------------------------------------------------------------------------------------------------------

## 1. Introduction 

Welcome to the CliniCal User Guide!

Clinic Calendar (CliniCal) is a **desktop app that allows doctors to manage patient records and schedule upcoming appointments**. With CliniCal, you can enhance your daily workflow through the effective scheduling of medical appointments. You can also have access to a digital database that safely stores all your patient records. 

Furthermore, CliniCal is optimized for use via a Command Line Interface (CLI) and even retains the benefits of a Graphical User Interface (GUI). If you can type fast, CliniCal can get your work done faster than traditional GUI apps.

Interested to know more? Take a look at our [**Quick Start**](#2-quick-start) guide. Enjoy!


## 2. Quick Start

Welcome to CliniCal! If you are new to our software, this quick start guide will get you up and running in no time! It equips you with the basics tools you need to use CliniCal appropriately.

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `CliniCal.jar` from [_here_](https://github.com/AY2021S1-CS2103T-W11-4/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for CliniCal.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press <kbd>Enter</kbd> to execute it. e.g. typing **`help`** and pressing <kbd>Enter</kbd> will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all your patients.

   * **`add`**`n/John Doe p/98765432 i/S2561932A a/Pickle street, Block 123, #01-01 e/johnd@example.com` : Adds a patient named `John Doe` to the patient database.

   * **`delete`**`3` : Deletes the 3rd patient shown in the patient list.

   * **`clear`** : Deletes all your patients.

   * **`exit`** : Exits the app.

1. Refer to the [**Features**](#3-features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 3. Features

This section highlights the commands that CliniCal supports. These include details about the format of the command and example scenarios of the command.

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [g/ALLERGY]` can be used as `n/John Doe g/penicillin` or as `n/John Doe`.

* Items with `…` after them can be used multiple times including zero times.<br>
  e.g. `[g/ALLERGY]…` can be used as ` ` (i.e. 0 times), `g/penicillin`, `g/sulfa g/aspirin` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### 3.1 General Commands

General commands are commands that enhances general user experience when you are using the app.

#### 3.1.1 Viewing help: `help`

Access help page by referring to the link provided in the message pop-up.

![help message](images/helpMessage.png)

Format: `help`

#### 3.1.2 Retrieving past commands: `history`

View a list of past commands that you had used during the session.

![example of command history](images/historyExample.png)

Format: `history`

#### 3.1.3 Clearing command history: `clearhistory`

Clear the command history.

![example of cleared history](images/clearHistoryExample.png)

Format: `clearhistory`

<div markdown="block" class="alert alert-info">

**:information_source: Note:**<br>

 * Use with caution, `clearhistory` cannot be undone!

</div>

#### 3.1.4 Exiting the program: `exit`

Exit the program.

Format: `exit`

### 3.2 Patient Commands

Patient commands are commands that you can utilise to make changes to your list of patients.

#### 3.2.1 Adding a patient: `add`

Add your patient to the patient database.

![example of newly added patient](images/addExample.png)

Format: `add n/NAME p/PHONE_NUMBER i/NRIC [a/ADDRESS] [e/EMAIL] [s/SEX] [b/BLOOD_TYPE] [ct/COLOR_TAG] [g/ALLERGY]…`

Examples:
* `add n/John Doe p/98765432 i/S3857462J e/johnd@example.com a/Pickle street, block 123, #01-01`
* `add n/Betsy Crowe i/G7667353B e/betsycrowe@example.com a/Newgate Prison p/1234567 g/penicillin`

<div markdown="block" class="alert alert-primary">
:bulb: <span style="font-weight:bold">Tips:</span>

* A patient can have any number of allergies (including 0).
* The color tag can be any standard HTML color name, such as <span style="color:red;font-weight:bold">red</span>, <span style="color:green;font-weight:bold">red</span> or <span style="color:red;font-weight:bold">orange</span>.
* Check out <a href="https://www.w3schools.com/colors/colors_names.asp">this link</a> for an extensive list.

</div>

<div markdown="block" class="alert alert-info">

**:information_source: Note about color coding patients:**<br>

 * When your patient is tagged with a color tag, the background of the patient will be styled to show that color. The color tags can be used for a variety of purposes.
 * For example, you may color code patients at risk of terminal diseases as <span style="color:red;font-weight:bold">red</span>, for easier reference.

</div>

#### 3.2.2 Adding profile picture: `addpicture`

Add a profile picture to your patient’s profile by specifying the filepath to desired profile picture.

All patient profiles are preloaded with a stock profile picture.

![example of patient with new profile](images/addProfileExample.png)

Format: `addpicture INDEX f/FILE_PATH`

Examples:
*  `addpicture 1 f/data/profile_picture.png` Replaces existing profile picture with 'profile_picture.png' for the 1st patient
*  `addpicture 2 f/downloads/profile_picture.png` Replaces existing profile picture with 'profile_picture.png' found in
                                                  'downloads' folder for the 2nd patient

<div markdown="block" class="alert alert-primary">
:bulb: <span style="font-weight:bold">Tip: </span>
<br>
* You can also add a profile picture using drag and drop with your mouse!
1. Select your desired profile picture and drag it onto the space reserved for patient profile picture in CliniCal.
1. Release the mouse button and your patient's profile picture would be updated with the desired picture.

</div>

#### 3.2.3 Editing a patient: `edit`

Edit an existing patient in the patient database.

![example of edited patient](images/editExample.png)

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [i/NRIC] [a/ADDRESS] [e/EMAIL] [s/SEX] [b/BLOOD_TYPE] [ct/COLOR_TAG] [g/ALLERGY]…`

* Edits the patient at the specified `INDEX`. The index refers to the index number shown in the displayed patient list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing allergies (or color tag), the existing allergies (or color tag) of the patient will be removed i.e adding of allergies (or color tag) is not cumulative.
* You can remove all the patient’s allergies by typing `g/` without specifying any allergies after it. The same applies for color tags of a patient.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st patient to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower g/` Edits the name of the 2nd patient to be `Betsy Crower` and clears all existing allergies.
*  `edit 3 ct/red` Clears the existing color tag and edits the color tag of the 3rd patient to be `red`.

![example of color coded patient](images/colorTagExample.png)

#### 3.2.4 Deleting a patient: `delete`

![example of deleted patient](images/deleteExample.png)

Delete a specified patient from the patient database.

Format: `delete INDEX`

* Deletes the patient at the specified `INDEX`.
* The index refers to the index number shown in the displayed patient list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd patient in the patient database.
* `find Betsy` followed by `delete 1` deletes the 1st patient in the results of the `find` command.

#### 3.2.5 Deleting all patients: `clear`

![example of cleared list](images/clearExample.png)

Clear all patient entries from the patient database.

Format: `clear`

<div markdown="block" class="alert alert-primary">
:bulb: <span style="font-weight:bold">Tip: </span>

* Reverse the `clear` command using the `undo` command!

</div>

#### 3.2.6 Finding patients: `find`

Find patients whose names or IC number contain any of the given keywords.

![example of finding meier](images/findExample.png)

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* You can search for the patient's name or IC number. 
* Patient will be matched even if the keyword matches the search parameters only partially e.g. `Han` will match `Hans`, `9123456` will match `s9123456z`.
* Patients matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find ben` returns `benjamin`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
* `find 9123456` returns the patient with IC number `s9123456z`

#### 3.2.7 Listing all patients: `list`

![example of listing patients](images/listExample.png)

View a list of all your patients in the patient database.

Format: `list`

<div markdown="block" class="alert alert-primary">
:bulb: <span style="font-weight:bold">Tip: </span>

You can revert your previous command which modified the patient database.

* Useful to view all patients after a `find` command!

</div>

#### 3.2.8 Undoing the previous command: `undo`

Revert your previous command which modified the patient database.

![example of undoing command](images/undoExample.png)

Format: `undo`

* Only applies for commands that modify the patient database such as `add`, `addpicture`, `edit`, `delete` and `clear`.
* Does not apply for undoable commands such as `find` and `list`.

Example: 
* While trying to `addpicture` , you deleted Alex Yeoh's patient details by accident.
* Instead of re-entering Alex Yeoh's information all over again, you can easily restore Alex Yeoh's details by using `undo` on your previous `delete` command.

#### 3.2.9 Redoing a command: `redo`

![example redoing command](images/redoExample.png)

Redo the most recent command that you have undone.

Format: `redo`

* Only able to `redo` commands that have been previously undone such as `add`, `addpicture`, `edit`, `delete` and `clear`.

### 3.3 Retrieving past commands using arrow keys

Retrieve and reuse past commands using the <kbd>↑</kbd> arrow and <kbd>↓</kbd> arrow keys on the keyboard.
1. Click on the text field of the command box.
2. Press the <kbd>↑</kbd> arrow key to display the most recent past command.
3. Press the <kbd>↓</kbd> and <kbd>↑</kbd> arrow keys to navigate through the list of past commands.
4. Press <kbd>Enter</kbd>/<kbd>Return</kbd> key to reuse the command.

<div markdown="block" class="alert alert-primary">
:bulb: <span style="font-weight:bold">Tip: </span>

* Useful when inputting repeated commands.
* No need to retype them all over again!

</div>

### 3.4 Saving the data

CliniCal data is saved in your hard disk automatically after any command that changes the data. There is no need to save manually.


--------------------------------------------------------------------------------------------------------------------

## 4. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous CliniCal home folder.

--------------------------------------------------------------------------------------------------------------------

## 5. Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER i/NRIC [a/ADDRESS] [e/EMAIL] [s/SEX] [b/BLOOD_TYPE] [ct/COLOR_TAG] [g/ALLERGY]…​` <br> e.g., `add n/James Ho p/22224444 i/S2686887R e/jamesho@example.com a/123, Clementi Rd, 1234665 s/M b/B+ g/sulfa g/aspirin`
**Add profile picture** | `addpicture 1 f/data/profile_picture.png`
**Clear** | `clear`
**Clear command history** | `clearhistory`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [i/NRIC] [a/ADDRESS] [e/EMAIL] [s/SEX] [b/BLOOD_TYPE] [ct/COLOR_TAG] [g/ALLERGY]…`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com `
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
**Undo** | `undo`
**Redo** | `redo`
**Retrieve past commands** | `history`
**Exit** | `exit`
