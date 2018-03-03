package com.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class having all the uni-codes for every character  
 * @author SuMiT
 * @since 7-Nov-2017
 */
public class FontUnicodeBundle {
    private FontUnicodeBundle(){}
    //public final static Map<String,ArrayList<Integer>> unicodeBundle=new TreeMap<String,ArrayList<Integer>>();
    
    public final static ArrayList<String> unicodeBundleArrayList=new ArrayList<String>();
    
    static{
        /*
        //for char 'a'
        ArrayList<Integer> char_a=new ArrayList<Integer>();
            char_a.add(0X00C0);char_a.add(0X00C1);char_a.add(0X00C2);char_a.add(0X00C3);char_a.add(0X00C4);
            char_a.add(0X00C5);char_a.add(0X00C6);char_a.add(0X00C7);char_a.add(0X00C8);char_a.add(0X00C9);
            char_a.add(0X00CA);
        unicodeBundle.put("a",char_a);
        
        //for char 'A'
        ArrayList<Integer> char_A=new ArrayList<Integer>();
            char_A.add(0X00CB);char_A.add(0X00CC);char_A.add(0X00CD);char_A.add(0X00CE);char_A.add(0X00CF);
            char_A.add(0X00D0);char_A.add(0X00D1);char_A.add(0X00D2);char_A.add(0X00D3);char_A.add(0X00D4);
            char_A.add(0X00D5);
        unicodeBundle.put("A",char_A);
        
        //for char 'b'
        ArrayList<Integer> char_b=new ArrayList<Integer>();
            char_b.add(0X00D6);char_b.add(0X00D7);char_b.add(0X00D8);char_b.add(0X00D9);char_b.add(0X00DA);
            char_b.add(0X00DB);char_b.add(0X00DC);char_b.add(0X00DD);char_b.add(0X00DE);char_b.add(0X00DF);
            char_b.add(0X00E0);
        unicodeBundle.put("b",char_b);
        
        //for char 'B'
        ArrayList<Integer> char_B=new ArrayList<Integer>();
            char_B.add(0X00E1);char_B.add(0X00E2);char_B.add(0X00E3);char_B.add(0X00E4);char_B.add(0X00E5);
            char_B.add(0X00E6);char_B.add(0X00E7);char_B.add(0X00E8);char_B.add(0X00E9);char_B.add(0X00EA);
            char_B.add(0X00EB);
        unicodeBundle.put("B",char_B);
        
        //for char 'c'
        ArrayList<Integer> char_c=new ArrayList<Integer>();
            char_c.add(0X00EC);char_c.add(0X00ED);char_c.add(0X00EE);char_c.add(0X00EF);char_c.add(0X00F0);
            char_c.add(0X00F1);char_c.add(0X00F2);char_c.add(0X00F3);char_c.add(0X00F4);char_c.add(0X00F5);
            char_c.add(0X00F6);
        unicodeBundle.put("c",char_c);
        
        //for char 'C'
        ArrayList<Integer> char_C=new ArrayList<Integer>();
            char_C.add(0X00F7);char_C.add(0X00F8);char_C.add(0X00F9);char_C.add(0X00FA);char_C.add(0X00FB);
            char_C.add(0X00FC);char_C.add(0X00FD);char_C.add(0X00FE);char_C.add(0X00FF);char_C.add(0X00B4);
            char_C.add(0X02D8);
        unicodeBundle.put("C",char_C);
        */
        //--------------------In String--------------------------
        //for char 'a'
        String str_a=0X0061+","+0X00C0+","+0X00C1+","+0X00C2+","+0X00C3+","+0X00C4+","+0X00C5+","+0X00C6+","+0X00C7+","+0X00C8+","+0X00C9+","+0X00CA;
        unicodeBundleArrayList.add(str_a);
        
        //for char 'A'
        String str_A=0X0041+","+0X00CB+","+0X00CC+","+0X00CD+","+0X00CE+","+0X00CF+","+0X00D0+","+0X00D1+","+0X00D2+","+0X00D3+","+0X00D4+","+0X00D5;
        unicodeBundleArrayList.add(str_A);
        
        //for char 'b'
        String str_b=0X0062+","+0X00D6+","+0X00D7+","+0X00D8+","+0X00D9+","+0X00DA+","+0X00DB+","+0X00DC+","+0X00DD+","+0X00DE+","+0X00DF+","+0X00E0;
        unicodeBundleArrayList.add(str_b);
        
        //for char 'B'
        String str_B=0X0042+","+0X00E1+","+0X00E2+","+0X00E3+","+0X00E4+","+0X00E5+","+0X00E6+","+0X00E7+","+0X00E8+","+0X00E9+","+0X00EA+","+0X00EB;
        unicodeBundleArrayList.add(str_B);
        
        //for char 'c'
        String str_c=0X0063+","+0X00EC+","+0X00ED+","+0X00EE+","+0X00EF+","+0X00F0+","+0X00F1+","+0X00F2+","+0X00F3+","+0X00F4+","+0X00F5+","+0X00F6;
        unicodeBundleArrayList.add(str_c);
        
        //for char 'C'
        String str_C=0X0043+","+0X00F7+","+0X00F8+","+0X00F9+","+0X00FA+","+0X00FB+","+0X00FC+","+0X00FD+","+0X00FE+","+0X00FF+","+0X00B4+","+0X02D8;
        unicodeBundleArrayList.add(str_C);
        
        //for char 'd'
        String str_d=0X0064+","+0X02C7+","+0X00B8+","+0X02C6+","+0X00A8+","+0X02D9+","+0X02DD+","+0X02DB+","+0X02DA+","+0X02DC+","+0X0102+","+0X0100;
        unicodeBundleArrayList.add(str_d);
        
        //for char 'D'
        String str_D=0X0044+","+0X0104+","+0X01FC+","+0X0106+","+0X010C+","+0X0108+","+0X010A+","+0X010E+","+0X0110+","+0X0114+","+0X011A+","+0X0116;
        unicodeBundleArrayList.add(str_D);
        
        //for char 'e'
        String str_e=0X0065+","+0X0112+","+0X0118+","+0X011E+","+0X011C+","+0X0122+","+0X0120+","+0X0126+","+0X0124+","+0X012C+","+0X0130+","+0X012A;
        unicodeBundleArrayList.add(str_e);
        
        //for char 'E'
        String str_E=0X0045+","+0X012E+","+0X0128+","+0X0132+","+0X0134+","+0X0136+","+0X0139+","+0X013D+","+0X013B+","+0X013F+","+0X0141+","+0X0143;
        unicodeBundleArrayList.add(str_E);
        
        //for char 'f'
        String str_f=0X0066+","+0X0147+","+0X0145+","+0X014E+","+0X0150+","+0X014C+","+0X01FE+","+0X0152+","+0X0154+","+0X0158+","+0X0156+","+0X015A;
        unicodeBundleArrayList.add(str_f);
        
        //for char 'F'
        String str_F=0X0046+","+0X0160+","+0X015E+","+0X015C+","+0X0218+","+0X0166+","+0X0164+","+0X0162+","+0X016C+","+0X0170+","+0X016A+","+0X0172;
        unicodeBundleArrayList.add(str_F);
    
        //Kajal
        
        //for char 'g'
        String str_g=0X0067+","+0X016E+","+0X0168+","+0X1E82+","+0X0174+","+0X1E84+","+0X1E80+","+0X0176+","+0X0178+","+0X1EF2+","+0X0179+","+0X017D;
        unicodeBundleArrayList.add(str_g);

        //for char 'G'
        String str_G = 0X0047+","+0X017B+","+0X0103+","+0X0101+","+0X0105+","+0X01FD+","+0X0107+","+0X010D+","+0X0109+","+0X010B+","+0X010F+","+0X0111;
        unicodeBundleArrayList.add(str_G);

        //for char 'h'
        String str_h = 0X0068+","+0X0115+","+0X011B+","+0X0117+","+0X0113+","+0X0119+","+0XFB00+","+0XFB03+","+0XFB04+","+0XFB01+","+0XFB02+","+0X011F;
        unicodeBundleArrayList.add(str_h);

        //for char 'H'
        String str_H = 0X0048+","+0X011D+","+0X0123+","+0X0121+","+0X0127+","+0X0125+","+0X012D+","+0X012B+","+0X012F+","+0X0129+","+0X0133+","+0X0131;
        unicodeBundleArrayList.add(str_H);

        //for char 'i'
        String str_i = 0X0069+","+0X0135+","+0X0137+","+0X0138+","+0X013A+","+0X013E+","+0X013C+","+0X0140+","+0X0142+","+0X0144+","+0X0149+","+0X0148;
        unicodeBundleArrayList.add(str_i);

        //for char 'I'
        String str_I = 0X0049+","+0X0146+","+0X014F+","+0X27BE+","+0X014D+","+0X01FF+","+0X0153+","+0X0155+","+0X0159+","+0X0157+","+0X015B;
        unicodeBundleArrayList.add(str_I);

        //for char 'j'
        String str_j = 0X006A+","+0X015F+","+0X015D+","+0X0219+","+0XFB06+","+0X0167+","+0X0165+","+0X0163+","+0X016D+","+0X0171+","+0X016B+","+0X0173;
        unicodeBundleArrayList.add(str_j);

        //for char 'J'
        String str_J = 0X004A+","+0X016F+","+0X0169+","+0X1E83+","+0X0175+","+0X1E85+","+0X1E81+","+0X0177+","+0X1EF3+","+0X017A+","+0X017E+","+0X017C;
        unicodeBundleArrayList.add(str_J);

        //for char 'k'
        String str_k = 0X006B+","+0X207F+","+0X014A+","+0X014B+","+0X017F+","+0XFB05+","+0X00A4+","+0X00A2+","+0X20AC+","+0X20A3+","+0X00A3+","+0X00A5;
        unicodeBundleArrayList.add(str_k);

        //for char 'K'
        String str_K = 0X004B+","+0X20A4+","+0X20A7+","+0X20A1+","+0X0192+","+0X2070+","+0X00B9+","+0X00B2+","+0X00B3+","+0X2074+","+0X2075+","+0X2076;
        unicodeBundleArrayList.add(str_K);

        //for char 'l'
        String str_l = 0X006C+","+0X2077+","+0X2078+","+0X2079+","+0X207D+","+0X207E+","+0X2080+","+0X2081+","+0X2082+","+0X2083+","+0X2084+","+0X2085;
        unicodeBundleArrayList.add(str_l);

        //for char 'L'
        String str_L = 0X004C+","+0X2086+","+0X2087+","+0X2088+","+0X2089+","+0X208D+","+0X208E+","+0X00BD+","+0X00BC+","+0X215B+","+0X2154+","+0X00BE;
        unicodeBundleArrayList.add(str_L);

        //for char 'm'
        String str_m = 0X006D+","+0X215C+","+0X215D+","+0X215E+","+0X27B4+","+0X201A+","+0X201E+","+0X201C+","+0X201D+","+0X00B1+","+0X00AB+","+0X00BB;
        unicodeBundleArrayList.add(str_m);

        //for char 'M'
        String str_M = 0X004D+","+0X2039+","+0X203A+","+0X2013+","+0X2014+","+0X00B7+","+0X2264+","+0X2248+","+0X2260+","+0X00AC+","+0X212E+","+0X2202;
        unicodeBundleArrayList.add(str_M);

        //for char 'n'
        String str_n = 0X006E+","+0X2265+","+0X27BD+","+0X00A6+","+0X2030+","+0X2026+","+0X2020+","+0X2021+","+0X2012+","+0X2212+","+0X2122+","+0X00A7;
        unicodeBundleArrayList.add(str_n);

        //for char 'N'
        String str_N = 0X004E+","+0X00A9+","+0X00AA+","+0X00AD+","+0X00B0+","+0X00B5+","+0X00BA+","+0X27BC+","+0X2024+","+0X2025+","+0X2116+","+0X2206;
        unicodeBundleArrayList.add(str_N);

        //for char 'o'
        String str_o = 0X006F+","+0X220F+","+0X2211+","+0X2215+","+0X2219+","+0X221A+","+0X221E+","+0X222B+","+0X021A+","+0X021B+","+0X02C9+","+0X037E;
        unicodeBundleArrayList.add(str_o);

        //for char 'O'
        String str_O = 0X004F+","+0X2113+","+0X038+","+0X0385+","+0X0387+","+0X0391+","+0X0386+","+0X0392+","+0X0393+","+0X0395+","+0X0388+","+0X0396;
        unicodeBundleArrayList.add(str_O);

        //for char 'p'
        String str_p = 0X0070+","+0X0397+","+0X0389+","+0X0398+","+0X0399+","+0X03AA+","+0X038A+","+0X039A+","+0X039B+","+0X039C+","+0X039D+","+0X27BB;
        unicodeBundleArrayList.add(str_p);

        //for char 'P'
        String str_P = 0X0050+","+0X039E+","+0X039F+","+0X038C+","+0X03A0+","+0X03A1+","+0X03A3+","+0X03A4+","+0X03A5+","+0X03AB+","+0X038E+","+0X03A6;
        unicodeBundleArrayList.add(str_P);


        //for char 'q'
        String str_q = 0X0071+","+0X03A7+","+0X03A8+","+0X2126+","+0X038F+","+0X03B1+","+0X03AC+","+0X03B2+","+0X03B3+","+0X03B4+","+0X03AD+","+0X03B6;
        unicodeBundleArrayList.add(str_q);

        //for char 'Q'
        String str_Q = 0X0051+","+0X03B7+","+0X03AE+","+0X03B8+","+0X27BA+","+0X03CA+","+0X0390+","+0X03AF+","+0X03BA+","+0X03BB+","+0X03BC+","+0X03BD;
        unicodeBundleArrayList.add(str_Q);

        //for char 'r'
        String str_r = 0X0072+","+0X3BE+","+0X03C0+","+0X03C1+","+0X03C2+","+0X03C3+","+0X03C4+","+0X03C5+","+0X27B9+","+0X03CB+","+0X03B0+","+0X03CD;
        unicodeBundleArrayList.add(str_r);

        //for char 'R'
        String str_R = 0X0052+","+0X03C6+","+0X03C7+","+0X03C8+","+0X03C9+","+0X03CE+","+0X03BF+","+0X03CC+","+0X03D0+","+0X03D1+","+0X03F0+","+0X0410;
        unicodeBundleArrayList.add(str_R);

        //for char 's'
        String str_s =  0X0073+","+0X411+","+0X0412+","+0X0413+","+0X0414+","+0X0415+","+0X0401+","+0X0416+","+0X0417+","+0X0418+","+0X0419+","+0X041A;
        unicodeBundleArrayList.add(str_s);

        //for char 'S'
        String str_S = 0X0053+","+0X41B+","+0X041C+","+0X041D+","+0X041E+","+0X041F+","+0X0420+","+0X0421+","+0X0422+","+0X0423+","+0X0424+","+0X0425;
        unicodeBundleArrayList.add(str_S);

        //for char 't' 
        String str_t = 0X0074+","+0X0426+","+0X0427+","+0X0428+","+0X0429+","+0X042A+","+0X042B+","+0X042C+","+0X042D+","+0X042E+","+0X042F+","+0X0490;
        unicodeBundleArrayList.add(str_t);

        //for char 'T'
        String str_T = 0X0054+","+0X27B8+","+0X0402+","+0X0403+","+0X0404+","+0X0405+","+0X0406+","+0X0407+","+0X0408+","+0X0409+","+0X040A+","+0X040B;
        unicodeBundleArrayList.add(str_T);

        //for char 'u'
        String str_u = 0X0075+","+0X040C+","+0X040E+","+0X0430+","+0X0431+","+0X0433+","+0X0434+","+0X0435+","+0X0451+","+0X0436+","+0X0437;
        unicodeBundleArrayList.add(str_u);

        //for char 'U'
        String str_U = 0X0055+","+0X0438+","+0X0439+","+0X043A+","+0X043B+","+0X043C+","+0X043D+","+0X043E+","+0X043F+","+0X0440+","+0X0441+","+0X0442;
        unicodeBundleArrayList.add(str_U);

        //for char 'v'
        String str_v = 0X0076+","+0X0443+","+0X0444+","+0X0445+","+0X0446+","+0X0447+","+0X0448+","+0X0449+","+0X044A+","+0X044B+","+0X044C+","+0X044D;
        unicodeBundleArrayList.add(str_v);

        //for char 'V'
        String str_V = 0X0056+","+0X044E+","+0X044F+","+0X0491+","+0X0452+","+0X0453+","+0X0454+","+0X0455+","+0X0456+","+0X0457+","+0X0458+","+0X0459;
        unicodeBundleArrayList.add(str_V);

        //for char 'w'
        String str_w = 0X0077+","+0X045A+","+0X045B+","+0X045C+","+0X045E+","+0X0462+","+0X0472+","+0X0474+","+0X045F+","+0X0463+","+0X0473;
        unicodeBundleArrayList.add(str_w);

        //for char 'W'
        String  str_W =  0X0057+","+0X0475+","+0X04D9+","+0X2701+","+0X2702+","+0X2703+","+0X2704+","+0X260E+","+0X2706+","+0X2707+","+0X2708+","+0X2709;
        unicodeBundleArrayList.add(str_W); 

        //for char 'x'
        String str_x = 0X0078+","+0X261B+","+0X261E+","+0X270C+","+0X270D+","+0X270E+","+0X270F+","+0X2710+","+0X2711+","+0X2712+","+0X2713+","+0X2714;
        unicodeBundleArrayList.add(str_x);

        //for char 'X'
        String str_X = 0X0058+","+0X2715+","+0X2716+","+0X2717+","+0X2718+","+0X2719+","+0X271A+","+0X271B+","+0X271C+","+0X271D+","+0X271E+","+0X271F;
        unicodeBundleArrayList.add(str_X);

        //for char 'y'
        String str_y = 0X0079+","+0X2720+","+0X2721+","+0X2722+","+0X2723+","+0X2724+","+0X2725+","+0X2726+","+0X27B7+","+0X2727+","+0X2605+","+0X2729;
        unicodeBundleArrayList.add(str_y);

        //for char 'Y' 
        String str_Y = 0X0059+","+0X272A+","+0X272B+","+0X272C+","+0X272D+","+0X272E+","+0X272F+","+0X2730+","+0X2731+","+0X2732+","+0X2733+","+0X2734;
        unicodeBundleArrayList.add(str_Y);

        //for char 'z'
        String str_z = 0X007A+","+0X2735+","+0X2736+","+0X2737+","+0X2738+","+0X2739+","+0X273A+","+0X273B+","+0X273C+","+0X273D+","+0X273E+","+0X273F;
        unicodeBundleArrayList.add(str_z);

        //for char 'Z' 
        String  str_Z = 0X005A+","+0X2740+","+0X2741+","+0X2742+","+0X2743+","+0X2744+","+0X2745+","+0X2746+","+0X2747+","+0X2748+","+0X2749+","+0X274A;
        unicodeBundleArrayList.add(str_Z);

        //for symbol '`'
        String str_tield =String.valueOf(0X0060) ;
        unicodeBundleArrayList.add(str_tield);

        //for digit '1'
        String str_d1 = 0X0031+","+0X274B+","+0X25CF+","+0X274D+","+0X25A0+","+0X274F;
        unicodeBundleArrayList.add(str_d1);

        //for digit '2'
        String str_d2 = 0X0032+","+0X2750+","+0X2751+","+0X2752+","+0X25B2+","+0X25BC;
        unicodeBundleArrayList.add(str_d2);

        //for digit '3'
        String str_d3 = 0X0033+","+0X25C6+","+0X2756+","+0X25D7+","+0X2758+","+0X2759;
        unicodeBundleArrayList.add(str_d3);

        //for digit '4'
        String str_d4 = 0X0034+","+0X275A+","+0X275B+","+0X275C+","+0X275D+","+0X275E;
        unicodeBundleArrayList.add(str_d4);

        //for digit '5'
        String str_d5 = 0X0035+","+0X2761+","+0X2762+","+0X2763+","+0X2764+","+0X2765;
        unicodeBundleArrayList.add(str_d5);

        //for digit '6'
        String str_d6 = 0X0036+","+0X2766+","+0X2767+","+0X2460+","+0X2461+","+0X2462;
        unicodeBundleArrayList.add(str_d6);

        //for digit '7'
        String str_d7 = 0X0037+","+0X2463+","+0X2464+","+0X2465+","+0X2466+","+0X2467;
        unicodeBundleArrayList.add(str_d7);

        //for digit '8'
        String str_d8 = 0X0038+","+0X2468+","+0X2469+","+0X2776+","+0X2777+","+0X2778;
        unicodeBundleArrayList.add(str_d8);

        //for digit '9'
        String str_d9 = 0X0039+","+0X2779+","+0X277A+","+0X277B+","+0X277C+","+0X277D;
        unicodeBundleArrayList.add(str_d9);

        //for digit '0'
        String str_d0 = 0X0030+","+0X277E+","+0X277F+","+0X2780+","+0X2781+","+0X2782;
        unicodeBundleArrayList.add(str_d0);
        
        //for digit '['
        String str = 0X005B+","+0X0E0C+","+0X0E0D+","+0X0E0E+","+0X0E0F+","+0X0E10+","+0X0E11+","+0X0E12+","+0X0E13+","+0X0E14+","+0X0E15+","+0X0E16;
        unicodeBundleArrayList.add(str);
        
        //for digit ']'
        String str1 = 0X005D+","+0X0E22+","+0X0E23+","+0X0E24+","+0X0E25+","+0X0E26+","+0X0E27+","+0X0E28+","+0X0E29+","+0X0E2A+","+0X0E2B+","+0X0E2C;
        unicodeBundleArrayList.add(str1);
        
        //for digit '{'
        String str2 = 0X007B+","+0X0E17+","+0X0E18+","+0X0E19+","+0X0E1A+","+0X0E1B+","+0X0E1C+","+0X0E1D+","+0X0E1E+","+0X0E1F+","+0X0E20+","+0X0E21;
        unicodeBundleArrayList.add(str2);
        
        //for digit '}'
        String str3 = 0X007D+","+0X0E2D+","+0X0E2E+","+0X0E2F+","+0X0E30+","+0X0E31+","+0X0E32+","+0X0E33+","+0X0E34+","+0X0E35+","+0X0E36+","+0X0E37;
        unicodeBundleArrayList.add(str3);
        
    }
}





