(ns games.core
  (:require
   [re-frame.core :as rf]
   [reagent.dom :as dom]
   [games.subs]
   [games.handlers]
   [games.routes :as routes]
   [games.views :as views]))

(defn render-app []
  (if-let [el (.getElementById js/document "app")]
    (dom/render [views/app] el)))

(enable-console-print!)
(routes/setup!)
(rf/dispatch-sync [:setup])
(render-app)
