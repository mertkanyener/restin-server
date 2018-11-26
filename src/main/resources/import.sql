
INSERT INTO "USER_" (ID, EMAIL, USERNAME, PASSWORD) VALUES(1, 'user1@email.com', 'user1', '{bcrypt}$2a$10$6ijmJ73mUqPbWlcJo5lzWOzwm154P9wdNO4..4eRdf4lYFL04/z.S');
INSERT INTO "ROLE" (ID, ROLE) VALUES (1, 'ADMIN');
INSERT INTO "ROLE" (ID, ROLE) VALUES (2, 'USER');
INSERT INTO "USER_ROLE" (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO "USER_ROLE" (USER_ID, ROLE_ID) VALUES (1, 2);
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (1, 1, 'memberbook', 'This is a test', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (2, 1, 'sqlTest', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (3, 1, 'sqlTest1', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (4, 1, 'sqlTest2', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (5, 1, 'sqlTest3', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (6, 1, 'sqlTest4', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (7, 1, 'sqlTest5', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (8, 1, 'sqlTest6', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (9, 1, 'sqlTest7', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (10, 1, 'sqlTest8', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (11, 1, 'sqlTest9', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (12, 1, 'sqlTest10', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (13, 1, 'sqlTest11', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (14, 1, 'sqlTest12', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (15, 1, 'sqlTest13', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (16, 1, 'sqlTest14', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (17, 1, 'sqlTest15', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (18, 1, 'sqlTest16', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (19, 1, 'sqlTest17', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (20, 1, 'sqlTest18', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (21, 1, 'sqlTest19', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (22, 1, 'sqlTest20', 'This is another test', 'Active');
-- INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (23, 1, 'sqlTest21', 'This is another test', 'Active');
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_PROTECTED, IS_DYNAMIC) VALUES (1, 1, 'members/1', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_PROTECTED, IS_DYNAMIC) VALUES (2, 2, 'members/2/emails/1', '{"errors":[{"status":"403","source":{"pointer":"/data/attributes/secret-powers"},"detail":"Editing secret powers is not authorized on Sundays."},{"status":"422","source":{"pointer":"/data/attributes/volume"},"detail":"Volume does not, in fact, go to 11."},{"status":"500","source":{"pointer":"/data/attributes/reputation"},"title":"The backend responded with an error","detail":"Reputation service not responding after three requests."}]}', 200, 'DELETE', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_PROTECTED, IS_DYNAMIC) VALUES (3, 2, 'admin/users/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_PROTECTED, IS_DYNAMIC) VALUES (4, 1, 'members/1/email', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);


