
INSERT INTO "USER_" (ID, EMAIL, USERNAME, PASSWORD) VALUES(1, 'user1@email.com', 'user1', '{bcrypt}$2a$10$6ijmJ73mUqPbWlcJo5lzWOzwm154P9wdNO4..4eRdf4lYFL04/z.S');
INSERT INTO "ROLE" (ID, ROLE) VALUES (1, 'ADMIN');
INSERT INTO "ROLE" (ID, ROLE) VALUES (2, 'USER');
INSERT INTO "USER_ROLE" (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO "USER_ROLE" (USER_ID, ROLE_ID) VALUES (1, 2);
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (1, 1, 'memberbook', 'This is a test', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (2, 1, 'sqlTest', 'This is another test', 'Active');
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_PROTECTED, IS_DYNAMIC) VALUES (1, 1, 'members/1', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_PROTECTED, IS_DYNAMIC) VALUES (2, 2, 'members/2/emails/1', '{"errors":[{"status":"403","source":{"pointer":"/data/attributes/secret-powers"},"detail":"Editing secret powers is not authorized on Sundays."},{"status":"422","source":{"pointer":"/data/attributes/volume"},"detail":"Volume does not, in fact, go to 11."},{"status":"500","source":{"pointer":"/data/attributes/reputation"},"title":"The backend responded with an error","detail":"Reputation service not responding after three requests."}]}', 200, 'DELETE', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_PROTECTED, IS_DYNAMIC) VALUES (3, 2, 'admin/users/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_PROTECTED, IS_DYNAMIC) VALUES (4, 1, 'members/1/email', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);


