# GPS Hawk Controllers

## Methods

### User Controller

All URLS start with `/app/users`

#### Login

Checks the login and returns a token

- URL: `/login/{deviceId}`
- Method: `GET`
- Header: `Authorization: Basic ENCRYPTED_DATA`
- Parameters:
    - deviceId
- Response-Format: `application/json`

Example:

```
GET: user:pass@server.domain/app/users/login/abcdefg
```

```json
{
    "success": true,
    "token": "f8ce212d-b380-4080-8e7e-db586e98c2f0"
}
```

#### User Exists

Checks if the user is existing

- URL: `/exists/{username}`
- Method: `GET`
- Header: ~
- Parameters: 
    - username
- Response-Format: Status Code

Example:

```
GET: server.domain/app/users/exists/user1
```

```
200
```

```
GET: server.domain/app/users/exists/user0
```

```
404
```

#### Register

Registers a new user and returns the token

- URL: `/register`
- Method: `POST`
- Headers: ~
- Parameters:
    - username
    - password
    - deviceId
- Response-Format: `application/json`
  
Example:

```
POST: server.domain/app/users/register
```

```json
{
    "success": true,
    "token": "2c3e2cf9-a934-4f56-ad75-0bb428d7d1de"
}
```

### App Controller

All URLS start with `/app`

#### Versions

Returns a json formatted object containing all versions with their URL and the current version

- URL: `/version`
- Method: `GET`
- Headers: ~
- Parameters: ~
- Response-Format: `application/json`

Example:

```
GET: server.domain/app/version
```

```json
{
  "current-version": 1,
  "versions": [
    {
      "version": 1,
      "url": "http://somefolder/release1.apk"
    },
    {
      "version": 2,
      "url": "http://somefolder/release2.apk"
    }
  ]
}
```