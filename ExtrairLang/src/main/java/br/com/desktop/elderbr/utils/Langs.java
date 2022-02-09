/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.desktop.elderbr.utils;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author User
 */
public class Langs extends DefaultComboBoxModel<String> {

    private String lang = null;

    // TODOS OS CÓDIGOS DE LANG DISPONIVÉL PARA A VERSÃO 1.17
    private final String[] langs = new String[]{"af_za", "ar_sa", "bg_bg", "ca_es",
        "cs_cz", "cy_gb", "da_dk", "de_de", "el_gr", "en_au", "en_ca", "en_gb",
        "en_pt", "eo_uy", "es_ar", "es_es", "es_mx", "es_uy", "es_ve", "et_ee",
        "eu_es", "fa_ir", "fil_ph", "fi_fi", "fr_ca", "fr_fr", "ga_ie", "gl_es",
        "he_il", "hi_in", "hr_hr", "hu_hu", "hy_am", "id_id", "is_is", "it_it",
        "ja_jp", "ka_ge", "ko_kr", "kw_gb", "la_la", "lb_lu", "lt_lt", "lv_lv",
        "ms_my", "mt_mt", "nl_nl", "nn_no", "no_no", "oc_fr", "pl_pl", "pt_br",
        "pt_pt", "qya_aa", "ro_ro", "ru_ru", "sk_sk", "sl_si", "sr_sp", "sv_se",
        "th_th", "tlh_aa", "tr_tr", "uk_ua", "vi_vn", "zh_cn", "zh_tw"};

    public Langs() {
    }

    @Override
    public String getElementAt(int index) {
        lang = langs[index];
        return lang;
    }

    @Override
    public int getSize() {
        return langs.length;
    }


    @Override
    public String toString() {        
        return lang;
    }
    
    

}
