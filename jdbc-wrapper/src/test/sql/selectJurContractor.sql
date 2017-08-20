SELECT DD_DS0."SCAPTION",
       DD_DS0."BISJUR",
       DD_DS0.DI_DS1,
       DD_DS0.SCAPTION_DS1
FROM
    (SELECT DD_DS0."BISJUR",
            DD_DS0."SCAPTION",
            DD_DS0."DI",
            DD_DS1.DI_DS1,
            DD_DS1.SCAPTION_DS1
        FROM
            (
                SELECT DD_DS0_B0."BISJUR",
                       DD_DS0_B0."SCAPTION",
                       DD_DS0_B0."DI"
                FROM
                    (
                        SELECT DD_DS0_B0."BISJUR",
                               DD_DS0_B0."SCAPTION",
                               DD_DS0_B0."DIGROUP",
                               DD_DS0_B0."DI"
                        FROM
                            (
                                SELECT DD_DS0_B0_T0."BISJUR",
                                       DD_DS0_B0_T0."SCAPTION",
                                       DD_DS0_B0_T0."DIGROUP",
                                       DD_DS0_B0_T1."DI"
                                FROM "CMN_CONTRACTOR" DD_DS0_B0_T0
                                INNER JOIN "CMN_JURCONTRACTOR" DD_DS0_B0_T1 ON (DD_DS0_B0_T1."DI" = DD_DS0_B0_T0."DI")
                            ) DD_DS0_B0
                    ) DD_DS0_B0
                INNER JOIN
                    (
                        SELECT DD_DS0_B1_T0."DI" AS DI_B1
                        FROM "CMN_CONTRACTORGROUP" DD_DS0_B1_T0
                    ) DD_DS0_B1 ON (DD_DS0_B0."DIGROUP" = DD_DS0_B1.DI_B1)
            ) DD_DS0
        INNER JOIN
            (
                SELECT DD_DS1_B0.SCAPTION_DS1,
                       DD_DS1_B0.DI_DS1
                FROM
                    (
                        SELECT DD_DS1_B0_T0."SCAPTION" AS SCAPTION_DS1,
                               DD_DS1_B0_T0."DI" AS DI_DS1,
                               DD_DS1_B0_T0."DIGROUP"
                        FROM "CMN_CONTRACTOR" DD_DS1_B0_T0
                    ) DD_DS1_B0
                INNER JOIN
                    (
                        SELECT DD_DS1_B1_T0."DI" AS DI_B1
                        FROM "CMN_CONTRACTORGROUP" DD_DS1_B1_T0
                    ) DD_DS1_B1 ON (DD_DS1_B0."DIGROUP" = DD_DS1_B1.DI_B1)
            ) DD_DS1 ON (DD_DS0."DI" = DD_DS1.DI_DS1)
    ) DD_DS0



