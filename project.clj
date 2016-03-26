(defproject games "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.34"]
                 [re-frame "0.7.0"]
                 [reagent "0.6.0-alpha"]
                 [kibu/pushy "0.3.6"]
                 [bidi "2.0.4"]]

  :plugins [[lein-figwheel "0.5.2"]
            [lein-cljsbuild "1.1.3"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"]

  :source-paths ["src"]

  :profiles {:repl
             {:source-paths ["dev"]
              :dependencies [[figwheel-sidecar "0.5.0-6" :exclusions [org.clojure/clojure]]
                             [com.cemerick/piggieback "0.2.1" :exclusions [org.clojure/clojure]]]}}

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel {:on-jsload "games.core/render-app"}
                :compiler {:main       "games.core"
                           :asset-path "js/compiled/out"
                           :output-to  "resources/public/js/compiled/games.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true}}
               {:id "prod"
                :source-paths ["src"]
                :compiler {:main       "games.core"
                           :asset-path "js/compiled/out"
                           :output-to  "resources/public/js/compiled/games.js"
                           :optimizations :advanced}}]}

  :figwheel {:css-dirs ["resources/public/css"]
             :ring-handler games.server/handler}

  :repl-options {:init-ns games.repl
                 :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]})
