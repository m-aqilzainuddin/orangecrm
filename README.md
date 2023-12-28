# ORANGE CRM

## E2E TEST
LOGIN
- [x] Correct username and correct password
- [x] Correct username and incorrect password
- [x] Incorrect username and correct password

ADMIN
- [x] Job Title: unable to add new job titles when “form incomplete” → verify correct error message displayed
- [x] Job Title: successfully cancel from adding job titles → verify job title not available on the list
- [x] Job Title: successfully add job title → verify job titles added on the list
- [x] Job Title: unable to add update job title details when “form incomplete” → verify correct error message displayed
- [x] Job Title: successfully cancel from updating job title details → verify job title details are not updated
- [x] Job Title: successfully update job title details → verify updated details displayed on the list
- [x] Job Title: successfully cancel from deleting job titles → verify job titles still available on the list
- [x] Job Title: successfully delete job titles → verify job titles are no longer on the list
- [x] Pay Grade: unable to add new pay grades when “form incomplete” → verify correct error message displayed
- [x] Pay Grade: successfully cancel from adding pay grades → verify job title not available on the list
- [x] Pay Grade: successfully add pay grades → verify job titles added on the list
- [x] Pay Grade: unable to add update pay grades details when “form incomplete” → verify correct error message displayed
- [x] Pay Grade: successfully cancel from updating pay grades details → verify job title details are not updated
- [x] Pay Grade: successfully update pay grade details → verify updated details displayed on the list
- [x] Pay Grade: successfully cancel from deleting pay grades → verify job titles still available on the list
- [x] Pay Grade: successfully delete pay grades → verify job titles are no longer on the list
- [x] Employment Status: unable to add new employment status when “form incomplete” → verify correct error message displayed
- [x] Employment Status: successfully cancel from adding employment status → verify job title not available on the list
- [x] Employment Status: successfully add employment status → verify job titles added on the list
- [x] Employment Status: unable to add update employment status details when “form incomplete” → verify correct error message displayed
- [x] Employment Status: successfully cancel from updating employment status details → verify job title details are not updated
- [x] Employment Status: successfully update employment status details → verify updated details displayed on the list
- [x] Employment Status: successfully cancel from deleting employment status → verify job titles still available on the list
- [x] Employment Status: successfully delete employment status → verify job titles are no longer on the list
- [x] Job Categories: unable to add new job categories when “form incomplete” → verify correct error message displayed
- [x] Job Categories: successfully cancel from adding job categories → verify job title not available on the list
- [x] Job Categories: successfully add job categories → verify job titles added on the list
- [x] Job Categories: unable to add update job categories details when “form incomplete” → verify correct error message displayed
- [x] Job Categories: successfully cancel from updating job categories details → verify job title details are not updated
- [x] Job Categories: successfully update job categories details → verify updated details displayed on the list
- [x] Job Categories: successfully cancel from deleting job categories → verify job titles still available on the list
- [x] Job Categories: successfully delete job categories → verify job titles are no longer on the list

PIM
- [x] Employee List: unable to add employee without login details when form incomplete → verify correct error message displayed
- [x] Employee List: successfully cancel add employee without login details → verify directed to form employee details with correct details
- [x] Employee List: successfully add employee without login details → verify directed to form employee details with correct details
- [x] Employee List: unable to add employee with login details when form incomplete → verify correct error message displayed
- [x] Employee List: successfully cancel add an employee with login details → verify directed to form employee details with correct details
- [x] Employee List: successfully add an employee with login details → verify directed to form employee details with correct details
- [x] Employee List: successfully cancel update employee details → verify details not updated
- [x] Employee List: successfully update employee details → verify details updated
- [x] Employee List: successfully cancel delete employee → verify employee not deleted
- [x] Employee List: successfully delete employee → verify employee deleted
- [x] Reports: unable to submit incomplete form → verify correct error message
- [x] Reports: successfully cancel add report → verify report not displayed on the list
- [x] Reports: successfully add report → verify correct report details displayed
- [x] Reports: successfully cancel update report → verify report details not updated
- [x] Reports: successfully update report → verify correct report details displayed
- [x] Reports: successfully cancel delete report → verify report not deleted
- [x] Reports: successfully delete report → verify report deleted
