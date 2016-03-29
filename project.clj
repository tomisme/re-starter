(defproject my-new-app "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.40"]
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
              :dependencies [[figwheel-sidecar "0.5.0-6"]
                             [com.cemerick/piggieback "0.2.1"]]}}

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel {:on-jsload "my-new-app.core/render-app"}
                :compiler {:main       "my-new-app.core"
                           :asset-path "/js/compiled/out" ; absolute path for dev server
                           :output-to  "resources/public/js/compiled/my-new-app.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true}}
               {:id "prod"
                :source-paths ["src"]
                :compiler {:main       "my-new-app.core"
                           :asset-path "js/compiled/out"
                           :output-to  "resources/public/js/compiled/my-new-app.js"
                           :optimizations :advanced}}]}

  :figwheel {:css-dirs ["resources/public/css"]
             :http-server-root "public"
             :ring-handler my-new-app.server/handler}

  :repl-options {:init-ns my-new-app.repl
                 :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]})
