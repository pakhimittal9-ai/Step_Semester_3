# STEP Semester 3 - Java Object-Oriented Programming

Welcome to the **STEP Semester 3** repository! This repository contains a complete, production-grade collection of Java programming assignments, hands-on lab exercises, and algorithmic problem-solving tasks completed during the Semester 3 STEP curriculum.

The project is structured into **8 modular units**, each containing **5 Classwork Problems** and **5 Homework / Assignment Problems** (80 solved Java programs in total), demonstrating concepts ranging from fundamental string manipulation and array algorithms to advanced Object-Oriented Design patterns, Encapsulation, Polymorphism, and Abstraction.

---

## 📚 Curriculum & Topic Breakdown

```text
Step_Semester_3/
├── string/                     # String fundamentals, frequency analysis, and search
├── stringOperations/           # CSV parsing, regex, validation, and encoding
├── Arrays/                     # Algorithmic array problems (Prefix Sum, Two Pointers, Kadane's)
├── ArraysandMethods/           # Multidimensional grids, matrix transformations, and modular methods
├── ClassesandObjects/          # Class anatomy, object lifecycle, constructors, and static context
├── Encapsulation/              # Data hiding, access control, and defensive copying
├── OOPFundamentals/            # Inheritance hierarchies, polymorphic grading, and billing models
└── Abstraction/                # Abstract classes, contracts, and interface design
```

---

## 📂 Detailed Module Index

### 1. `string` (String Basics & Algorithms)
Core string algorithms, frequency mapping, and string-matching problems.
- **Classwork (`classproblems/`):**
  - `BmiCalculator.java`: Computes Body Mass Index (BMI) and health category based on weight and height inputs.
  - `FirstNonRepeating.java`: Identifies the first non-repeating character in a string using frequency analysis.
  - `PalindromeChecker.java`: Validates whether an input string is a palindrome ignoring casing and non-alphanumeric characters.
  - `ReverseName.java`: Reverses and formats person names and substrings cleanly.
  - `RockPaperScissors.java`: Implements turn-based game logic and move comparisons.
- **Homework (`assignmentproblems/`):**
  - `InventoryBalancer.java`: String-based analysis for balancing stock inventories and SKU identifiers.
  - `SeatChecker.java`: Validates flight and theater seat codes against spatial configuration patterns.
  - `SignalStreak.java`: Analyzes consecutive signal streaks and character sequences in transmission strings.
  - `TypingAccuracy.java`: Evaluates typing speed and accuracy percentage by comparing reference text to user input.
  - `WordLengthProfiler.java`: Analyzes word lengths and computes token distribution statistics across a text.

---

### 2. `stringOperations` (String Processing & Parsing)
Text manipulation, data sanitization, CSV parsing, and formatting utilities.
- **Classwork (`classproblems/`):**
  - `FileExtensionValidator.java`: Extracts and validates file extensions from raw system file paths.
  - `MaskedPhoneFormatter.java`: Formats and masks sensitive customer phone numbers for secure display.
  - `StudentCsvParser.java`: Parses and transforms CSV records containing student academic data.
  - `TransactionReference.java`: Generates and verifies unique transaction reference codes.
  - `VowelConsonantCounter.java`: Tallies vowels and consonants across sentences while filtering punctuation.
- **Homework (`assignmentproblems/`):**
  - `InventoryCsvParser.java`: Parses multi-column CSV inventory data into structured product attributes.
  - `IsbnNormalizer.java`: Cleans, formats, and validates 10-digit and 13-digit International Standard Book Numbers.
  - `PinLengthValidator.java`: Enforces security PIN requirements and digit validation rules.
  - `StopWordFrequency.java`: Filters natural language stop words and tallies term frequencies in sentences.
  - `WordReversalEncoder.java`: Reverses individual words in-place while maintaining overall sentence structure.

---

### 3. `Arrays` (Data Structures & Array Algorithms)
Classic algorithmic problems using two-pointer techniques, prefix sums, and sliding windows.
- **Classwork (`classproblems/`):**
  - `BestTimeToBuySellStock.java`: Computes maximum possible single-transaction profit from daily stock quotes.
  - `ContainsDuplicate.java`: Checks for duplicate elements within an integer array in linear time.
  - `MergeSortedArrays.java`: Merges two pre-sorted integer arrays into a single unified sorted array in O(m+n).
  - `RotateArray.java`: Cyclic array rotation by k positions using reversal techniques.
  - `TwoSum.java`: Identifies indices of two array elements that sum to a given target value.
- **Homework (`assignmentproblems/`):**
  - `FindMinRotated.java`: Discovers the minimum element in a rotated sorted array using binary search in O(log n).
  - `MaximumSubarray.java`: Implements Kadane's algorithm to compute the maximum contiguous subarray sum in O(n).
  - `ProductExceptSelf.java`: Computes prefix and suffix products such that each element is the product of all others without division.
  - `SubarraySumEqualsK.java`: Finds the total count of continuous subarrays whose cumulative sum equals k.
  - `ThreeSum.java`: Finds all distinct triplets in an array that sum to zero using sorting and two pointers.

---

### 4. `ArraysandMethods` (2D Grids, Matrices & Modular Methods)
Multidimensional array manipulations, matrix transformations, and modular method decomposition.
- **Classwork (`classproblems/`):**
  - `DuplicateTeamFinder.java`: Detects duplicate team entries using modular array helper methods.
  - `PlacementDriveEngine.java`: Manages campus placement candidate records and score evaluation using methods.
  - `ScoreCurveBooster.java`: Applies curving formulas and scale transformations to test score arrays.
  - `SeatingGridOptimizer.java`: 2D array matrix operations to optimize classroom or auditorium seating layouts.
  - `TopThreePodium.java`: Identifies the top three highest scores from a tournament array.
- **Homework (`assignmentproblems/`):**
  - `DuplicatePickChecker.java`: Verifies drafting rules to prevent duplicate player selections in fantasy leagues.
  - `FantasyAutoDraft.java`: Simulates fantasy team auto-drafting across rounds using multidimensional arrays.
  - `FantasyScoreMultiplier.java`: Applies performance multipliers across team rosters and position groups.
  - `MatchDayGridAnalyzer.java`: Analyzes match fixtures and scores stored in a 2D matrix grid.
  - `TopPerformerTracker.java`: Tracks and ranks top performers across rounds with array-based leaderboards.

---

### 5. `ClassesandObjects` (Object-Oriented Basics & Encapsulated State)
Object creation, reference semantics, constructor overloading (`this()`), and static class members.
- **Classwork (`classproblems/`):**
  - `CollegeInfo.java`: Models student attendance and tracks college-wide student counts with `static` variables and methods.
  - `CourseCredits.java`: Represents academic courses and calculates credit requirements.
  - `LibraryIdCard.java`: Models student library ID cards with issuance tracking and references.
  - `MessWallet.java`: Implements a digital mess wallet with balance top-up, deduction, and validation guards.
  - `PlacementRecords.java`: Encapsulates student placement records and package details.
- **Homework (`assignmentproblems/`):**
  - `CompanyInfo.java`: Tracks company-wide headcount and employee records using static class fields and methods.
  - `EmployeeProfile.java`: Demonstrates constructor overloading and constructor chaining (`this()`) for permanent vs intern employees.
  - `HallTicketReference.java`: Exam hall ticket generation and student reference association.
  - `LibraryInventory.java`: Tracks book titles, copies, and borrowing state within a library.
  - `PayrollManagement.java`: Manages employee salary accounts, deductions, and payroll computations.

---

### 6. `Encapsulation` (Data Hiding, Getters/Setters & Defensive Copying)
Enforcing state invariants, restricting field access, and safeguarding internal arrays from mutation.
- **Classwork (`classproblems/`):**
  - `AttendanceSheetDemo.java`: Encapsulates classroom attendance records with private arrays and defensive getters.
  - `LockerDemo.java`: Models a secure digital locker with private PIN and access verification.
  - `NameTagDemo.java`: Encapsulates conference name tags with formatted display rules.
  - `PiggyBankDemo.java`: Implements a secured savings bank allowing deposits and controlled break/withdraw operations.
  - `ScorecardDemo.java`: Encapsulates sports scorecard data ensuring scores cannot be arbitrarily modified.
- **Homework (`assignmentproblems/`):**
  - `CartDemo.java`: Demonstrates encapsulated shopping cart operations with quantity limits and totals.
  - `HealthBar.java`: Encapsulates character game health (0–100%) preventing invalid health states.
  - `PasswordCheckerDemo.java`: Enforces password complexity rules with private attributes and validator methods.
  - `PlaylistDemo.java`: Protects playlist tracks using defensive copying (`Arrays.copyOf`) to prevent unauthorized external mutation.
  - `TrafficLightDemo.java`: Manages traffic light state transitions through controlled setter methods.

---

### 7. `OOPFundamentals` (Inheritance & Polymorphism)
Subclassing, method overriding, hierarchical dispatch, and real-world system modeling.
- **Classwork (`classproblems/`):**
  - `DeliveryFees.java`: Models delivery fee calculations for different order sizes and distance tiers using inheritance.
  - `ExamGrader.java`: Polymorphic exam question evaluation supporting MCQ, True/False, and keyword-matched Essay questions.
  - `LibraryDueDates.java`: Computes return due dates and loan periods for books vs multimedia items.
  - `PaymentFees.java`: Base and derived payment methods calculating transaction surcharges.
  - `TransportFares.java`: Computes public transit fares across bus, metro, and rail classes.
- **Homework (`assignmentproblems/`):**
  - `CanteenBilling.java`: Hierarchical billing models for student vs faculty canteen orders with discount rules.
  - `FestivalBonus.java`: Computes festive bonuses across employee hierarchies using method overriding.
  - `HostelElectricity.java`: Tiered billing system for student hostel utility meters.
  - `ParkingCharges.java`: Vehicle parking tariff system differentiating 2-wheelers, 4-wheelers, and commercial vehicles.
  - `RenewalReminder.java`: Membership subscription renewals with tiered reminder schedules.

---

### 8. `Abstraction` (Abstract Classes & Interfaces)
Abstract base classes, interface contracts, multiple interfaces, and polymorphic business logic.
- **Classwork (`classproblems/`):**
  - `ElectricityBilling.java`: Abstract `Connection` base class with specialized `HomeConnection`, `ShopConnection`, and `FactoryConnection` billing strategies.
  - `GardenPlotReport.java`: Abstract shape modeling calculating areas and costs for agricultural/garden plots.
  - `LibraryLateFines.java`: Abstract borrowable item system (`BookItem`, `MagazineItem`, `DvdItem`) enforcing distinct late fine rate rules.
  - `TravelBooking.java`: Abstract booking system computing costs for flights, trains, and buses.
  - `WeeklyStaffPay.java`: Abstract `Staff` contract defining weekly pay computation for full-time, hourly, and intern staff.
- **Homework (`assignmentproblems/`):**
  - `ApplianceEnergyReport.java`: Abstract electrical appliance energy meter computing daily consumption and efficiency.
  - `CabFareMeter.java`: Abstract `Cab` base class with `NightService` interface defining surge/night fare capabilities across Mini, Sedan, and SUV.
  - `CollegeFeeCounter.java`: Abstract student fee engine integrating `BusUser` interface transport add-ons.
  - `MovieTicketCounter.java`: Abstract ticket pricing model with screen type modifiers (Standard, IMAX, 4DX).
  - `ParcelShippingDesk.java`: Abstract shipping system calculating rates for standard, express, and overnight couriers.

---

## 🛠️ How to Compile and Run

### Prerequisites
- **JDK 11 or higher** (JDK 17 / 21 / 25 recommended)

Check your Java installation:
```bash
java -version
javac -version
```

### Running an Individual Program
Execute single-file Java source files directly or compile with `javac`:

```bash
# Direct run (Java 11+)
java Abstraction/assignmentproblems/CabFareMeter.java

# Or traditional compilation:
javac Abstraction/assignmentproblems/CabFareMeter.java
java Abstraction.assignmentproblems.CabFareMeter
```

### Batch Compilation
To verify and compile all Java files across the entire project at once:

```powershell
# PowerShell (Windows)
Get-ChildItem -Recurse -Filter "*.java" | ForEach-Object { javac -d bin $_.FullName }
```

```bash
# Bash (Linux / macOS)
find . -name "*.java" -exec javac -d bin {} +
```

---

## 👤 Author
- **GitHub**: [@pakhimittal9-ai](https://github.com/pakhimittal9-ai)