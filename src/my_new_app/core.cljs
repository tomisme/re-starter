(ns my-new-app.core
  (:require
   [re-frame.core :as rf]
   [reagent.dom :as dom]
   [my-new-app.subs]
   [my-new-app.handlers]
   [my-new-app.views :as views]))

(defn render-app []
  (if-let [el (.getElementById js/document "app")]
    (dom/render [views/app] el)))

(enable-console-print!)
(rf/dispatch-sync [:setup])
(render-app)
