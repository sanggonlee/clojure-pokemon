# clojure-pokemon

Rokemon data REST server

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## API

### Rokemon

`rokemon.herokuapp.com/pokemon`: Get all rokemons

`rokemon.herokuapp.com/pokemon/random`: Get one random rokemon

`rokemon.herokuapp.com/pokemon/:id`: Get one rokemon with the given ID