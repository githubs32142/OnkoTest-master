(clear)
(reset)

(deftemplate Person
(slot age)
)

(deftemplate Rakpluc
(slot istnieje))

(deftemplate Rakjelitagrubego
(slot istnieje))

(deftemplate Rakgruczolukrokowego
(slot istnieje))

(deftemplate Rakpiersi
(slot istnieje))

(deftemplate Rakskory
(slot istnieje))

(deftemplate Rakjajnikow
(slot istnieje))

(deftemplate RiskFactor
(slot sp_alkohol)
(slot otylosc)
(slot pro_jonizujace)
(slot radioterapia)
(slot lam_solarium)
(slot pal_papierosow)
(slot br_akt_fizycznej)
(slot nie_dieta)
(slot br_nat_antykoksydantow)
(slot menopazua_otylosc)
(slot br_blonnika)
(slot pol_elektromagnetyczne)
(slot prom_ultra)
(slot kon_azbest)
(slot wcz_wsp_sexualne)
(slot wcz_rodz)
(slot diet_w_tluszcze)
(slot cz_sp_czerw_mieso)
(slot spoz_pok_smazonych)
(slot spoz_pok_grill)
(slot dos_antykoncepcja)
(slot sz_miesiacza)
(slot poz_w_rodzenia)
(slot w_r_piersi)
(slot bezdzietnosc)
)

(deftemplate Symptoms
(slot goraczka)
(slot oslabienie)
(slot blad_skory)
(slot apatia)
(slot stan_podgoraczkowe)
(slot os_apetyt)
(slot dusznosc)
(slot kr_jam_ustna)
(slot slk_infekcj)
(slot ob_poty)
(slot mdlosci)
(slot cz_bol_glowy)
(slot cz_bol_brzucha)
(slot sw_skory)
(slot pow_wezly_chlonne)
(slot pokaslywanie)
(slot chudniecie)
(slot kr_stolc)
(slot sl_stolcu)
(slot zm_tr_wypozniania)
(slot wycz_guz_krok)
(slot as_gr_krok)
(slot guz_w_piersi)
(slot as_piersi)
(slot n_do_miesa)
(slot kr_mocz)
(slot zm_skora)
(slot sk_na_piersi)
(slot wciek_brodawka)
(slot niet_krwawienie)
)

(deftemplate FamillyCancer
(slot brat_pluc)
(slot brat_jelito)
(slot brat_piersi)
(slot brat_jader)
(slot brat_gru_krok)
(slot brat_mozg)
(slot brat_syjki_macic)
(slot brat_trzustka)
(slot brat_zoladka)
(slot brat_krtani)
(slot brat_jajnik)
(slot siostra_pluc)
(slot siostra_jelito)
(slot siostra_piersi)
(slot siostra_jader)
(slot siostra_gru_krok)
(slot siostra_mozg)
(slot siostra_syjki_macic)
(slot siostra_trzustka)
(slot siostra_zoladka)
(slot siostra_krtani)
(slot siostra_jajnik)
(slot ojciec_pluc)
(slot ojciec_jelito)
(slot ojciec_piersi)
(slot ojciec_jader)
(slot ojciec_gru_krok)
(slot ojciec_mozg)
(slot ojciec_syjki_macic)
(slot ojciec_trzustka)
(slot ojciec_zoladka)
(slot ojciec_krtani)
(slot ojciec_jajnik)
(slot matka_pluc)
(slot matka_jelito)
(slot matka_piersi)
(slot matka_jader)
(slot matka_gru_krok)
(slot matka_mozg)
(slot matka_syjki_macic)
(slot matka_trzustka)
(slot matka_zoladka)
(slot matka_krtani)
(slot matka_jajnik)
(slot dziadek_pluc)
(slot dziadek_jelito)
(slot dziadek_piersi)
(slot dziadek_jader)
(slot dziadek_gru_krok)
(slot dziadek_mozg)
(slot dziadek_syjki_macic)
(slot dziadek_trzustka)
(slot dziadek_zoladka)
(slot dziadek_krtani)
(slot dziadek_jajnik)
(slot babcia_pluc)
(slot babcia_jelito)
(slot babcia_piersi)
(slot babcia_jader)
(slot babcia_gru_krok)
(slot babcia_mozg)
(slot babcia_syjki_macic)
(slot babcia_trzustka)
(slot babcia_zoladka)
(slot babcia_krtani)
(slot babcia_jajnik)
(slot wujek_pluc)
(slot wujek_jelito)
(slot wujek_piersi)
(slot wujek_jader)
(slot wujek_gru_krok)
(slot wujek_mozg)
(slot wujek_syjki_macic)
(slot wujek_trzustka)
(slot wujek_zoladka)
(slot wujek_krtani)
(slot wujek_jajnik)
(slot ciotka_pluc)
(slot ciotka_jelito)
(slot ciotka_piersi)
(slot ciotka_jader)
(slot ciotka_gru_krok)
(slot ciotka_mozg)
(slot ciotka_syjki_macic)
(slot ciotka_trzustka)
(slot ciotka_zoladka)
(slot ciotka_krtani)
(slot ciotka_jajnik)
)

; ############Reguły dotyczące raka płuc###########
(defrule rulerp1
         (and (RiskFactor (pal_papierosow 1) ) (exists (or (Symptoms (goraczka 1)) (Symptoms(pokaslywanie 1)) (Symptoms(chudniecie 1))  (Symptoms(oslabienie 1)  ))))
	=>
	 (assert (Rakpluc (istnieje 1)))
)
(defrule rulerp2
         (and (RiskFactor (pal_papierosow 1) ) (exists (and (Symptoms(pokaslywanie 1)) (Symptoms(chudniecie 1))  )))
	=>
	 (assert (Rakpluc (istnieje 1)))
)
(defrule rulerp3
         (and (RiskFactor (pal_papierosow 1) ))
	=>
	(assert (Rakpluc (istnieje 1)))
)

(defrule rulerp4
          (and (Symptoms (goraczka 1)) (Symptoms(pokaslywanie 1)) (Symptoms(chudniecie 1))  (Symptoms(oslabienie 1)  ))
	=>
	 (assert (Rakpluc (istnieje 1)))
)
(defrule RakPluc
    (Rakpluc (istnieje 1))
    =>
    (printout t "Rak płuc"crlf )

)

; ###############Reguły dotyczące raka jelita grubego############### 

( defrule sm_cz
	( RiskFactor (otylosc ?ans1 )(diet_w_tluszcze ?ans2 )(br_akt_fizycznej ?ans3 ) (cz_sp_czerw_mieso ?ans4 ) (spoz_pok_smazonych ?ans5 ) (spoz_pok_grill ?ans6 ))
	=>
	(assert (Sum6 (+ ?ans1 ?ans2 ?ans3 ?ans4 ?ans5 ?ans6 )))
)
(defrule person1 
	(Person ( age ?age ) )(test (> ?age 49))
 =>
        (assert (Sum (+ 0 1)))
)

(defrule rulerjg0
          (exists (or (FamillyCancer (brat_jelito 1)) (FamillyCancer(siostra_jelito 1)) (FamillyCancer(ojciec_jelito 1))  (FamillyCancer(matka_jelito 1)  )))
	=>
	 (assert (Sum2 (+ 0 1)))
)


(defrule rulerjg1
	(and (Sum6 ?sum6 ) (Sum ?sum) (Sum2 ?sum2))
	=>
	(assert (CancerJG (+ ?sum6  ?sum ?sum2 )))
)

(defrule rulerjg2
	(CancerJG ?tmp )(test (> ?tmp 2))
	=>
	(assert (Rakjelitagrubego (istnieje 1)))
)
(defrule rulerjg3
         (and (Symptoms (zm_tr_wypozniania 1) ) (exists (or (Symptoms(kr_stolc 1)) (Symptoms(sl_stolcu 1))  )))
	=>
	 (assert (Rakjelitagrubego (istnieje 1)))
)

(defrule rulerjg4
          (exists (and (Symptoms(kr_stolc 1)) (Symptoms(sl_stolcu 1))  ))
	=>
	(assert (Rakjelitagrubego (istnieje 1)))
)

(defrule RakJelitaGrubego
    (Rakjelitagrubego (istnieje 1))
    =>
    (printout t "Rak jelita grubego"crlf )

)


; ###############Reguły dotyczące raka piersi(nie wszystko) #####################
( defrule sm_cz2
	( RiskFactor (dos_antykoncepcja ?ans1 )(sz_miesiacza ?ans2 )(poz_w_rodzenia ?ans3 ) (br_akt_fizycznej ?ans4 ) (w_r_piersi ?ans5 ) (sp_alkohol ?ans6 ) (menopazua_otylosc ?ans7 ) )
	=>
	(assert (Sum7 (+ ?ans1 ?ans2 ?ans3 ?ans4 ?ans5 ?ans6 ?ans7 )))
)

(defrule rulerpp1
	(and (Sum7 ?sum7 ) (Sum ?sum) )
	=>
	(assert (CancerPP (+ ?sum7  ?sum  )))
)

(defrule rulerpp2
	(CancerPP ?tmp )(test (> ?tmp 2))
	=>
	(assert (Rakpiersi (istnieje 1)))
)
(defrule rulerpp3
          (exists (or (Symptoms (guz_w_piersi 1)) (Symptoms(as_piersi 1)) (Symptoms(sk_na_piersi 1))  (Symptoms(wciek_brodawka 1)  )))
	=>
	 (assert (Rakpiersi (istnieje 1)))
)

(defrule RakPiersi
    (Rakpiersi (istnieje 1))
    =>
    (printout t "Rak piersi"crlf )

)

;############## Reguły dotyczące raka gruczołu krokowego#####################

( defrule sm_cz3
	( RiskFactor (br_akt_fizycznej ?ans1 )(cz_sp_czerw_mieso ?ans2 )(otylosc ?ans3 ) (pal_papierosow ?ans4 )  )
	=>
	(assert (Sum4 (+ ?ans1 ?ans2 ?ans3 ?ans4  )))
)

(defrule person2 
	(Person ( age ?age ) )(test (> ?age 59))
 =>
        (assert (SumAge2 (+ 0 1)))
)

(defrule rulergk1
          (exists (or (FamillyCancer (brat_gru_krok 1)) (FamillyCancer(siostra_gru_krok 1)) (FamillyCancer(ojciec_gru_krok 1))  (FamillyCancer(matka_gru_krok 1)  )))
	=>
	 (assert (SumFamilly2 (+ 0 1)))
)

(defrule rulergk2
	(and (Sum4 ?sum4 ) (SumAge2 ?sumage2) (SumFamilly2 ?sumfamilly2))
	=>
	(assert (CancerGK (+ ?sum4  ?sumage2 ?sumfamilly2 )))
)

(defrule rulergk3
	(CancerGK ?tmp )(test (> ?tmp 2))
	=>
	(assert (Rakgruczolukrokowego (istnieje 1)))
)

(defrule rulergk4
         (exists (and (Symptoms(wycz_guz_krok 1)) (Symptoms(as_gr_krok 1))  ))
	=>
	 (assert (Rakgruczolukrokowego (istnieje 1)))
)

(defrule RakGruczoluKrokowego
    (Rakgruczolukrokowego (istnieje 1))
    =>
    (printout t "Rak gruczołu krokowego"crlf )

)

; Rak jajników 

( defrule sm_cz3
	( FamillyCancer (ciotka_jajnik ?ans1 )(babcia_jajnik ?ans2 )(matka_jajnik ?ans3 ) (siostra_jajnik ?ans4 ) )
	=>
	(assert (Sum_cz3 (+ ?ans1 ?ans2 ?ans3 ?ans4)))
)

( defrule sm_cz4
	( RiskFactor (bezdzietnosc ?ans1 )(otylosc ?ans2 ) )
	=>
	(assert (Sum_cz4 (+ ?ans1 ?ans2 )))
)

(defrule rulerj0
	(and (Sum_cz3 ?sumc3 ) (SumAge2 ?sumage2) (Sum_cz4 ?sumc4))
	=>
	(assert (CancerJ (+ ?sumc3  ?sumage2 ?sumc4 )))
)
(defrule rulerj1
	(CancerJ ?tmp )(test (> ?tmp 2))
	=>
	(assert (Rakjajnikow (istnieje 1)))
)

(defrule rulerj2
	(and (Symptoms (niet_krwawienie 1)))
	=>
	(assert (Rakjajnikow (istnieje 1)))
)

(defrule RakJajnikow
    (Rakjajnikow (istnieje 1))
    =>
    (printout t "Rak jajników"crlf )

)

;rak żołądla nie wszystko

( defrule sm_cz5
	( RiskFactor (otylosc ?ans1 ) (pal_papierosow ?ans2 )  )
	=>
	(assert (Sumcz5 (+ ?ans1 ?ans2 )))
)
( defrule sm_cz6
	( Symptoms (chudniecie ?ans1 ) (os_apetyt ?ans2 ) (n_do_miesa ?ans3 ) )
	=>
	(assert (Sumcz6 (+ ?ans1 ?ans2 ?ans3 )))
)
(defrule rulezz0
	(Sumcz5 ?tmp )(test (> ?tmp 1))
	=>
	(assert (RuleZZ0 (+ 0 1)))
)

(defrule rulezz1
	(Sumcz6 ?tmp )(test (> ?tmp 1))
	=>
	(assert (RuleZZ1 (+ 0 1)))
)

(defrule rulezz3
	(and (RuleZZ1 ?zz1 ) (RuleZZ0 ?zz0) )
	=>
	(assert (CancerZZ (+ ?zz1  ?zz0  )))
)
(defrule rulezz4
	(CancerZZ ?tmp )(test (> ?tmp 1))
	=>
	(printout t "Rak żołądka"  crlf)
)
;########################Rak przewodu moczowego #############################
(defrule rulerpm0
         (and (RiskFactor (pal_papierosow 1)) (Symptoms(kr_mocz 1)) (Symptoms(oslabienie 1)) )
	=>
	 (printout t "Rak przewodu moczoweego"  crlf)
)

;########################Rak skóry #############################
(defrule rulers0
         (or (RiskFactor (lam_solarium 1)) (RiskFactor(prom_ultra 1))  )
	=>
	 (assert (Rakskory (istnieje 1)))
)

(defrule rulers1
         (or  (Symptoms(zm_skora 1))  )
	=>
	 (assert (Rakskory (istnieje 1)))
)

(defrule RakSkory
    (Rakgruczolukrokowego (istnieje 1))
    =>
    (printout t "Rak skóry"crlf )

)

; ##############
(facts)
(run)
