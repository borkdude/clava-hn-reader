(ns styling
  (:require ["react-jss" :as jss]
            ["color" :as color]))

(defn create-styles
  [style-map]
  (jss/createUseStyles style-map))

(def bg-color "rgb(246, 246, 239)")
(def dark-bg (-> bg-color color (.darken 0.1) .hex))
(def font-color "#222")
(def light-color (-> font-color color (.lighten 3) .hex))

(def css-underline
  {:cursor :pointer
   :text-decoration :none
   "&:hover" {:text-decoration :underline}})

(def css-a
  (merge {:white-space "nowrap"
          :overflow "hidden"
          :color font-color
          :text-overflow "ellipsis"}
         css-underline))

(def css-a-light
  (assoc css-a :color light-color))

(def use-styles
  (create-styles
   {"@global" {:html {:scroll-behavior "smooth"}
               :body
               {:font-size "10pt"
                :font-family "Verdana, Geneva, sand-serif"}
               :p {:margin-bottom "0"}}

    :main {:margin "10px 20px 10px 20px"
           :color font-color
           :background-color bg-color
           "& > .header" {:font-weight "600"
                          :background-color "#ff6600"
                          :padding "10px 5px"
                          :margin-bottom "10px"}
           "& > .items" {:margin "0 10px 0 10px"}}

    :underline css-underline

    :story-item
    {:margin-bottom "5px"
     "& .story-body" {:margin-bottom "20px"}
     "& .comments" {:display "flex"
                    :flex-direction "column"
                    "& .comment" {:margin-top "10px"}
                    "& .comments" {:margin-left "20px"}}
     "& .item-row" {:display :flex
                    :align-items :baseline
                    :flex-direction :row
                    :flex-wrap :wrap
                    :align-content :center
                    :justify-content :flex-start
                    "& > a" {:margin-right "3px"}
                    "& > .title" css-a
                    "& > .info" (merge {:font-size "8pt"
                                        :color light-color}
                                       {"& a" css-a-light})
                    "& .date" {:color light-color}
                    "& .url"
                    (merge {:font-size "8pt"}
                           {"& a" css-a-light})}}}))
