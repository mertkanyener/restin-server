INSERT INTO "OAUTH_CLIENT_DETAILS" (CLIENT_ID, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY) VALUES ('mert', '{bcrypt}$2a$10$8Nh0sH.OPszy0V37xFnNHeg9rIxZNpbv9TSKPnIFOSL7XpcrWNb1G', 'read,write,trust', 'password,refresh_token', 'ROLE_ADMIN,ROLE_USER', 3600, 540000 )

INSERT INTO "USER_" (ID, EMAIL, USERNAME, PASSWORD) VALUES(1, 'user1@email.com', 'user1', '{bcrypt}$2a$10$6ijmJ73mUqPbWlcJo5lzWOzwm154P9wdNO4..4eRdf4lYFL04/z.S');
INSERT INTO "ROLE" (ID, ROLE) VALUES (1, 'ADMIN');
INSERT INTO "ROLE" (ID, ROLE) VALUES (2, 'USER');
INSERT INTO "USER_ROLE" (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO "USER_ROLE" (USER_ID, ROLE_ID) VALUES (1, 2);
INSERT INTO "PROJECT" (ID, USER_ID, NAME, STATUS) VALUES (1, 1, 'memberbook', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (2, 1, 'testApi', 'This is another test', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (3, 1, 'web-service', 'This is another test', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (4, 1, 'backend', 'This is another test', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (5, 1, 'mailer', 'This is another test', 'Inactive');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (6, 1, 'website-backend', 'This is another test', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (7, 1, 'spring-boot', 'This is another test', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (8, 1, 'backend-php', 'This is another test', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (9, 1, 'server', 'This is another test', 'Inactive');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (10, 1, 'amadeus-api', 'This is another test', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (11, 1, 'rest-api', 'This is another test', 'Active');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (12, 1, 'backend-rest', 'This is another test', 'Inactive');
INSERT INTO "PROJECT" (ID, USER_ID, NAME, DESCRIPTION, STATUS) VALUES (13, 1, 'spring-rest', 'This is another test', 'Active');
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (1, 1, 'member/1', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (2, 2, 'member/2/emails/1', '{"errors":[{"status":"403","source":{"pointer":"/data/attributes/secret-powers"},"detail":"Editing secret powers is not authorized on Sundays."},{"status":"422","source":{"pointer":"/data/attributes/volume"},"detail":"Volume does not, in fact, go to 11."},{"status":"500","source":{"pointer":"/data/attributes/reputation"},"title":"The backend responded with an error","detail":"Reputation service not responding after three requests."}]}', 200, 'DELETE', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (3, 2, 'admin/users/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (4, 1, 'admin/member/35/update', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (5, 1, 'member/1/flights', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (6, 1, 'member/3/account', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (7, 1, 'members/all', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (8, 1, 'admin/members/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (9, 1, 'admin/member/6/account/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 401, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (10, 1, 'admin/member/94/account/delete', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'DELETE', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (11, 1, 'register', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 500, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (12, 1, 'login', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 403, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (13, 1, 'register', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (14, 3, 'admin/users/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (15, 3, 'admin/users/all', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (16, 3, 'wrong/url', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 404, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (17, 3, 'member/1', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (18, 3, 'member/2/emails/1', '{"errors":[{"status":"403","source":{"pointer":"/data/attributes/secret-powers"},"detail":"Editing secret powers is not authorized on Sundays."},{"status":"422","source":{"pointer":"/data/attributes/volume"},"detail":"Volume does not, in fact, go to 11."},{"status":"500","source":{"pointer":"/data/attributes/reputation"},"title":"The backend responded with an error","detail":"Reputation service not responding after three requests."}]}', 200, 'DELETE', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (19, 3, 'admin/member/35/update', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (20, 3, 'member/1/flights', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (21, 3, 'member/3/account', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (22, 3, 'members/all', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (23, 3, 'admin/members/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (24, 3, 'admin/member/6/account/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 401, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (25, 3, 'admin/member/94/account/delete', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'DELETE', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (26, 3, 'register', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 500, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (27, 3, 'login', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 403, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (28, 3, 'register', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (29, 4, 'admin/users/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (30, 4, 'admin/users/all', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (31, 4, 'wrong/url', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 404, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (32, 4, 'member/1', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (33, 4, 'member/2/emails/1', '{"errors":[{"status":"403","source":{"pointer":"/data/attributes/secret-powers"},"detail":"Editing secret powers is not authorized on Sundays."},{"status":"422","source":{"pointer":"/data/attributes/volume"},"detail":"Volume does not, in fact, go to 11."},{"status":"500","source":{"pointer":"/data/attributes/reputation"},"title":"The backend responded with an error","detail":"Reputation service not responding after three requests."}]}', 200, 'DELETE', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (34, 4, 'admin/member/35/update', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (35, 4, 'member/1/flights', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (36, 4, 'member/3/account', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (37, 4, 'members/all', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (38, 4, 'admin/members/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (39, 4, 'admin/member/6/account/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 401, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (40, 4, 'admin/member/94/account/delete', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'DELETE', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (41, 4, 'register', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 500, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (42, 4, 'login', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 403, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (43, 4, 'register', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (44, 5, 'admin/users/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (45, 5, 'admin/users/all', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (46, 5, 'wrong/url', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 404, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (47, 5, 'member/1', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (48, 5, 'member/2/emails/1', '{"errors":[{"status":"403","source":{"pointer":"/data/attributes/secret-powers"},"detail":"Editing secret powers is not authorized on Sundays."},{"status":"422","source":{"pointer":"/data/attributes/volume"},"detail":"Volume does not, in fact, go to 11."},{"status":"500","source":{"pointer":"/data/attributes/reputation"},"title":"The backend responded with an error","detail":"Reputation service not responding after three requests."}]}', 200, 'DELETE', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (49, 5, 'admin/member/35/update', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (50, 5, 'member/1/flights', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (51, 5, 'member/3/account', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (52, 5, 'members/all', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'GET', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (53, 5, 'admin/members/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (54, 5, 'admin/member/6/account/new', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 401, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (55, 5, 'admin/member/94/account/delete', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'DELETE', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (56, 5, 'register', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 500, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (57, 5, 'login', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 403, 'POST', 0, 0);
INSERT INTO "URL" (ID, PROJECT_ID, PATH, RESPONSE, RESPONSE_CODE, METHOD, IS_MIRRORED, IS_DYNAMIC) VALUES (58, 5, 'register', '{"data":[{"type": "articles","id": "1","attributes": {"title": "JSON API paints my bikeshed!","body": "The shortest article. Ever."},"relationships": {"author": {"data": {"id": "42", "type": "people"}}}}],"included": [{"type": "people","id": "42","attributes": {"name": "John"}}]}', 200, 'POST', 0, 0);


