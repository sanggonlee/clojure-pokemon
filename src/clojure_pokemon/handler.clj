(ns clojure-pokemon.handler
  (:use compojure.core)
  (:use cheshire.core)
  (:use ring.util.response)
  (:require [compojure.handler :as handler]
            [ring.middleware.json :as middleware]
            [clojure.java.io :as io]
            [compojure.route :as route]))

(defn get-all-pokemons []
  (parse-string (slurp (io/resource "data/pokemons.json"))))

(defn handle-get-all-pokemons []
  {:body (get-all-pokemons)})

(defn handle-get-random-pokemon []
  (let [pokemons (get-all-pokemons)
        idx (rand-int (count pokemons))]
    {:body (nth pokemons idx)}))

(defn handle-get-pokemon [id]
  {:body (first (filter #(= (get % :id)) (get-all-pokemons)))})

(defroutes app-routes
  (context "/pokemon" [] (defroutes pokemon-routes
    (GET "/" [] (handle-get-all-pokemons))
    (GET "/random" [] (handle-get-random-pokemon))
    (context "/:id" [id] (defroutes pokemon-routes
      (GET "/" [] (handle-get-pokemon id))))))
  (route/not-found "Not found"))

(def app
  (middleware/wrap-json-response (handler/api app-routes)))
