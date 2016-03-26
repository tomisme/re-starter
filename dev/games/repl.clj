(ns games.repl
  (:use [figwheel-sidecar.repl-api :as ra]))

(defn fig
  []
  (ra/start-figwheel!)
  (ra/cljs-repl "dev"))

(defn unfig
  []
  (ra/stop-figwheel!))
