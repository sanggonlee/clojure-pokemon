(defproject clojure-pokemon "0.1.0-SNAPSHOT"
  :description "Pokemon data REST server to serve data for Sang-gon's code camp"
  :url "http://clojure-pokemon.herokuapp.com"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-json "0.1.2"]
                 [cheshire "4.0.3"]
                 [javax.servlet/servlet-api "2.5"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler clojure-pokemon.handler/app}
  :profiles
  :main clojure-pokemon.handler
  {:dev {:dependencies [[ring/ring-mock "0.3.0"]]}})
