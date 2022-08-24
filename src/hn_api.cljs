(ns hn-api)

(def base-url "https://hacker-news.firebaseio.com/v0")

(defn fetcher
  [uri]
  ^:async
  (fn [cbl]
    (let [resp (js/await (js/fetch (str base-url uri)))
          data (js/await (.json resp))]
      (cbl data))))

(defn item-fetcher
  [item-id]
  (fetcher (str "/item/" item-id ".json")))
