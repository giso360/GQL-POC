# Book / Author with GraphQL

- Run Application from IntelliJ

- Navigate to GraphiQL in the browser [localhost:8080/graphiql]()

- Send the following GQL queries:

  `query bookDetails {
    bookById(id: "book-2") {
      id
      name
      author {
        id
        firstName
        lastName
      }
    }
  }`

  OR

  `query {
    booksByGender(gender: "female"){
      name
      author {
        id
      }
    }
  }`
  
  
  
  
  
  
