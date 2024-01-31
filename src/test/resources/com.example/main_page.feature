Feature: ToDo App mine-todos.netlify.app Functionality

  Scenario: Adding and deleting new task
    Given the user is on the ToDo app homepage
    When the user adds a new task with title "To pick up Ami"
    Then the task "To pick up Ami" should appear in the task list
    When the user deletes a task
    Then the task list should not contain the deleted task

  Scenario: Editing a task
    Given the user is on the ToDo app homepage
    When the user adds a new task with title "To pick up Ami"
    When the user edits a task "To pick up Ami" to "To feed Amelie"
    Then the task list should display "To feed Amelie"


#  Scenario Outline: Editing a task
#    Given the user has tasks in the list
#    When the user edits a task with title "<oldTitle>" to "<newTitle>"
#    Then the task list should display "<newTitle>"
#
#    Examples:
#      | oldTitle       | newTitle     |
#      | To pick Ami    | To feed Ami  |
#      | To do homework | Java homework|
