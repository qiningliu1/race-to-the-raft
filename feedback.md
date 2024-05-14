---
mark: 2.90625

section_marks:
  c1-compliance: 0.25
  c2-git: 0.15
  c3-constructors: 1.0
  c4-viewer: 0.0
  c5-tests: 1.5
  c6-design: 0.0
  c7-outstanding: 0.35

deductions:
  - name: |-
      checksum
    weight: 0
  - name: |-
      compliance
    weight: 0.25
  - name: |-
      Task2
    weight: 0.09375
---

Deductions:
c2: Git commit messages should be meaningful. Messages such as 'added some classes and documentation' or 'Have finished part of tasks' do not explain what changes have been done in each
commit.
c4: Viewer not working.
c6: Game elements are modeled by classes, however, tasks in RaceToTheRaft are solved by manipulating strings instead
of making use of these classes. You may want to go over your classes and think of the relationship between them. Challenge
class stores a list of locations of existing cats, however, you also created a Cat class that has not been used. Think of 
where you would like to model your whole game (should record the current state of different elements).

Code Quality:
Insufficient amount of comments. Some of your code are redundant/repeated, which could be simplified for 
cleaner code.



