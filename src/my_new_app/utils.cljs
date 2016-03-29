(ns my-new-app.utils)

(defn log
  [arg]
  (.log js/console arg) arg)
