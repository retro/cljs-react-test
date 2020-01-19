(defproject org.clojars.mihaelkonjevic/cljs-react-test "0.1.6"
  :description "A ClojureScript wrapper around Reacts Test Utilities"
  :url "https://github.com/bensu/cljs-react-test"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"]
                 [cljsjs/react "16.12.0-1"]
                 [camel-snake-kebab "0.4.0"]]

  :scm {:name "git"
        :url "https://github.com/bensu/cljs-react-test"}

  :deploy-repositories [["clojars" {:creds :gpg}]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-doo "0.1.11"]]

  :aliases {"test" ["with-profile" "test" "doo" "chrome" "test"]}

  :source-paths ["src"]

  :profiles {:test {:dependencies [[prismatic/dommy "1.1.0"]
                                   [cljsjs/react-dom "16.12.0-1" :exclusions [cljsjs/react]]]}}

  :cljsbuild {:builds
              {:test {:source-paths ["src" "test"]
                      :compiler {:output-to "target/testable.js"
                                 :output-dir "target"
                                 :main test.test-runner
                                 :source-map true
                                 :optimizations :none
                                 :cache-analysis false
                                 :pretty-print true}}}})
