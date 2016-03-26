(ns games.utils)

(defn log
  [arg]
  (.log js/console arg) arg)
