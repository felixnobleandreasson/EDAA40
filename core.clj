(ns amoebas.TOKYODIFT.core
(:use amoebas.defs amoebas.lib amoebas.run)


(defn super-selector
  "we should define our selector method here ->"
    [arg1 arg2 arg3]



  )
  (defn most-energy-and-fuel-target-selector
      "picks a target with the highest sum of stored energy and energy in the cell it is in"
      [hs species env]

      (let
          [energy-and-fuel
              (fn [cell]
                  (if (:occupant cell)
                      (+ (:fuel cell) (:energy (:occupant cell)))
                      (:fuel cell)
                  )
              )
          ]

          (last (sort-by #(energy-and-fuel (env %)) hs))
      )
  )


(defn mindless-divider

    [energy health species env data]

    (if (< energy (+ MinDivideEnergy (/ (- MaxAmoebaEnergy MinDivideEnergy) 2)))
        {:cmd :rest}
        (if (< (rand) 0.3)                      ;; divide with probability 0.3
            {:cmd :divide, :dir (rand-int 8)}
            {:cmd :move, :dir (rand-int 8)}
        )
    )
)

(def Evam (create-mindless-divider 0.01))
