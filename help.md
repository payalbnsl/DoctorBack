post request to /oauth/token to get the access token passing grant_type= password, username= root password= root123 (for whom we are getting the token) Also basic auth, username=client, password=secret

With access token, make hit to api/users: auth: bearer token, paste token : get request