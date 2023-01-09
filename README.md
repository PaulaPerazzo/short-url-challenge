# Short url challenge
This project is a url shortener and redirector, made using Java Spring Boot.

## Dependencies used

1. Spring Boot JPA.
2. Spring Boot Starter Web.
3. Spring Boot DevTools.
4. H2 database.
5. Spring Boot Starter Test.
6. Commons Validator.


## Package manager
- Maven

## Running the project

1. Be sure you have JDK and Java installed.
2. Clone the repository by running
```bash
git clone https://github.com/PaulaPerazzo/short-url-challenge.git
```
### Sending a request (POST)
In Insomnia or Postman, send a Json in path: <http://localhost:8080/link>
```bash
{
  "link" : "https://www.any-link-here.com"
}
```
- This action should return a new short link (<http://localhost:8080/link/cat.me/{abcde}>).

### Sending a request (GET)
In your browse, access the link returned in POST method. It should redirect to the original link.

### Sending a request (GET)
To access all generated links, use the path: <http://localhost:8080/link>, using get method. It should return something like this:
```bash
[
    {
        "id": 1,
        "link": "https://pt.stackoverflow.com/questions/3882/menus-do-eclipse-sumiram",
        "shortLink": "http://localhost:8080/link/cat.me/Hnstt",
        "cliks": 0
    },
    {
        "id": 2,
        "link": "https://pt.stackoverflow.com/questions/3882/menus-do-eclipse-sumiram",
        "shortLink": "http://localhost:8080/link/cat.me/cmpDa",
        "cliks": 0
    },
    {
        "id": 3,
        "link": "https://pt.stackoverflow.com/questions/3882/menus-do-eclipse-sumiram",
        "shortLink": "http://localhost:8080/link/cat.me/fzFtY",
        "cliks": 0
    },
    {
        "id": 4,
        "link": "https://pt.stackoverflow.com/questions/3882/menus-do-eclipse-sumiram",
        "shortLink": "http://localhost:8080/link/cat.me/sWJsj",
        "cliks": 3
    }
]
```

### Sending a request (GET)
To view clicks stats of shorter links generated, access path: <http://localhost:8080/statistc/{abcde}>

## Development by
- Paula Perazzo
