/**
 * 
 */
package edu.mit.civil.sapoutputfile.fem;

/**
 * @author koleary
 *
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SapTextFile {

	public static String sapFile(final int numstorys, final double bays,
			final double colhgt, final double width1, final double live,
			final double sdl, final double loadwidth) {

		double width = width1;

		try {
			String filePath = "///Users/koleary/Desktop/SAP_Import_File.txt";

			PrintWriter pw = new PrintWriter(filePath);

			pw.println("TABLE:  \"PROGRAM CONTROL\"");
			pw.println("ProgramName=SAP2000   Version=11.0.8   ProgLevel=Advanced   LicenseOS=No   LicenseSC=No   LicenseBR=No   LicenseHT=No   CurrUnits=\"Kip, ft, F\"   SteelCode=AISC360-05/IBC2006   ConcCode=\"ACI 318-05/IBC2003\"   AlumCode=\"AA-ASD 2000\" _");
			pw.println("ColdCode=AISI-ASD96   RegenHinge=Yes");
			pw.println("");
			pw.println("TABLE:  \"ACTIVE DEGREES OF FREEDOM\"");
			pw.println("UX=Yes   UY=Yes   UZ=Yes   RX=Yes   RY=Yes   RZ=Yes");
			pw.println("");
			pw.println("TABLE:  \"ANALYSIS OPTIONS\"");
			pw.println("Solver=Advanced   Force32Bit=No   StiffCase=None   GeomMod=No");
			pw.println("");
			pw.println("TABLE:  \"MATERIAL PROPERTIES 01 - GENERAL\"");
			pw.println(" Material=A992Fy50   Type=Steel   SymType=Isotropic   TempDepend=No   Color=Green   Notes=\"ASTM A992 Fy=50 ksi added 2/23/2015 3:16:27 PM\"");
			pw.println("");
			pw.println("TABLE:  \"ANALYSIS OPTIONS\"");
			pw.println("Solver=Advanced   Force32Bit=No   StiffCase=None   GeomMod=No");
			pw.println("");
			pw.println("TABLE:  \"COORDINATE SYSTEMS\"");
			pw.println("   Name=GLOBAL   Type=Cartesian   X=0   Y=0   Z=0   AboutZ=0   AboutY=0   AboutX=0");
			pw.println("");
			pw.println("TABLE:  \"GRID LINES\"");
			pw.println("");

			// double nodes = (colhgts + 1) * (bays + 1);

			for (int i = 0; i < (bays + 1); i++) {

				pw.println("CoordSys=GLOBAL   AxisDir=X   GridID=x"
						+ (i + 1)
						+ "   XRYZCoord= "
						+ ((i * width1) - width1 * bays * 0.5)
						+ ",   LineType=Primary   LineColor=Gray8Dark   Visible=Yes   BubbleLoc=End");
			}

			pw.println("CoordSys=GLOBAL   AxisDir=Y   GridID=y1   XRYZCoord=0   LineType=Primary   LineColor=Gray8Dark   Visible=Yes   BubbleLoc=Start AllVisible=Yes   BubbleSize=5");

			for (int i = 0; i < (numstorys + 1); i++) {

				pw.println("CoordSys=GLOBAL   AxisDir=Z   GridID=z"
						+ (i + 1)
						+ "   XRYZCoord= "
						+ ((i * colhgt))
						+ ",   LineType=Primary   LineColor=Gray8Dark   Visible=Yes   BubbleLoc=End");
			}

			pw.println("TABLE:  \"MATERIAL PROPERTIES 01 - GENERAL\"");
			pw.println("   Material=A992Fy50   Type=Steel   SymType=Isotropic   TempDepend=No   Color=Green  ");
			pw.println("");
			pw.println("TABLE:  \"MATERIAL PROPERTIES 02 - BASIC MECHANICAL PROPERTIES\"");
			pw.println("   Material=A992Fy50   UnitWeight=0.49   UnitMass=1.52296649007508E-02   E1=4176000   G12=1606153.84615385   U12=0.3   A1=0.0000065");
			pw.println("");
			pw.println("TABLE:  \"MATERIAL PROPERTIES 03A - STEEL DATA\"");
			pw.println("   Material=A992Fy50   Fy=7200   Fu=9360   EffFy=7920   EffFu=10296   SSCurveOpt=Simple   SSHysType=Kinematic   SHard=0.015   SMax=0.11   SRup=0.17");
			pw.println("");
			pw.println("TABLE:  \"MATERIAL PROPERTIES 06 - DAMPING PARAMETERS\"");
			pw.println("   Material=A992Fy50   ModalRatio=0   VisMass=0   VisStiff=0   HysMass=0   HysStiff=0");
			// TODO Input Damping??
			pw.println("");

			pw.println("	TABLE:  \"FRAME SECTION PROPERTIES 01 - GENERAL\"	");

			pw.println("	   SectionName=Beams   Shape=\"Auto Select\"   AutoType=Steel   Color=Magenta   Notes=\"Imported 3/4/2015 11:31:50 AM from AISC.PRO\"	");
			pw.println("	   SectionName=COLS   Shape=\"Auto Select\"   AutoType=Steel   Color=Magenta   Notes=\"Imported 3/4/2015 11:32:40 AM from AISC.PRO\"	");
			pw.println("		");
			pw.println("	   SectionName=W10X22   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=0.847500006357829   t2=0.479166666666667   tf=3.00000011920929E-02   tw=1.99999995529652E-02   t2b=0.479166666666667   tfb=3.00000011920929E-02 _	");
			pw.println("	        Area=4.50694428549872E-02   TorsConst=1.15740738153734E-05   I33=5.69058641975309E-03   I22=5.49768500122023E-04   AS2=1.69499996635649E-02   AS3=2.39583336644702E-02   S33=1.34291123942492E-02   S22=2.29468591355279E-03 _	");
			pw.println("	        Z33=1.50462962962963E-02   Z22=3.53009253740311E-03   R33=0.355334533525115   R22=0.110445704967148   ConcCol=No   ConcBeam=No   Color=White   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W10X22   	");
			pw.println("		");
			pw.println("	   SectionName=W10X26   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=0.860833326975505   t2=0.480833331743876   tf=3.66666664679845E-02   tw=2.16666658719381E-02   t2b=0.480833331743876   tfb=3.66666664679845E-02 _	");
			pw.println("	        Area=5.28472231494056E-02   TorsConst=1.92901237442354E-05   I33=6.94444444444444E-03   I22=6.79976870248347E-04   AS2=1.86513894134098E-02   AS3=2.93840269247691E-02   S33=1.61342369697591E-02   S22=2.82832667935986E-03 _	");
			pw.println("	        Z33=0.01811342548441   Z22=4.34027777777778E-03   R33=0.362499713617251   R22=0.113432103026832   ConcCol=No   ConcBeam=No   Color=Gray8Dark   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W10X26   	");
			pw.println("		");
			pw.println("	   SectionName=W10X30   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=0.872500022252401   t2=0.484166661898295   tf=4.24999992052714E-02   tw=2.50000009934107E-02   t2b=0.484166661898295   tfb=4.24999992052714E-02   Area=0.061388889948527 _	");
			pw.println("	        TorsConst=2.98996915879809E-05   I33=8.1983024691358E-03   I22=8.05362691113978E-04   AS2=2.18125002251731E-02   AS3=3.42951383855608E-02   S33=1.87926699370654E-02   S22=3.32679944528339E-03   Z33=2.11805546725238E-02 _	");
			pw.println("	        Z22=5.11574082904392E-03   R33=0.365440838223978   R22=0.114538334351612   ConcCol=No   ConcBeam=No   Color=Blue   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W10X30  	");
			pw.println("		");
			pw.println("	   SectionName=W10X33   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=0.810833295186361   t2=0.663333336512248   tf=3.62500001986821E-02   tw=2.41666659712791E-02   t2b=0.663333336512248   tfb=3.62500001986821E-02 _	");
			pw.println("	        Area=6.74305558204651E-02   TorsConst=2.7970678207499E-05   I33=8.1983024691358E-03   I22=1.76504622271031E-03   AS2=1.95951395564609E-02   AS3=0.040076388253106   S33=2.02219186553051E-02   S22=5.32174737965314E-03 _	");
			pw.println("	        Z33=2.24537032621878E-02   Z22=8.10185185185185E-03   R33=0.348685268057616   R22=0.161789253732287   ConcCol=No   ConcBeam=No   Color=Green   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W10X33  	");
			pw.println("		");
			pw.println("	   SectionName=W10X39   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=0.826666673024495   t2=0.665416677792867   tf=4.41666642824809E-02   tw=2.62499998013178E-02   t2b=0.665416677792867   tfb=4.41666642824809E-02 _	");
			pw.println("	        Area=7.98611111111111E-02   TorsConst=4.72608033889606E-05   I33=1.00790895061728E-02   I22=2.17013888888889E-03   AS2=2.16999997695287E-02   AS3=4.89819447199504E-02   S33=2.43848937790049E-02   S22=6.52264652003332E-03 _	");
			pw.println("	        Z33=2.70833328918174E-02   Z22=9.95370414521959E-03   R33=0.355257272224791   R22=0.164845118348947   ConcCol=No   ConcBeam=No   Color=Cyan   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W10X39   	");
			pw.println("		");
			pw.println("	   SectionName=W10X45   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=0.841666698455811   t2=0.668333371480306   tf=0.051666667064031   tw=2.91666661699613E-02   t2b=0.668333371480306   tfb=0.051666667064031   Area=9.23611124356588E-02 _	");
			pw.println("	        TorsConst=7.28202155894703E-05   I33=1.19598765432099E-02   I22=2.57523155506746E-03   AS2=2.45486117071576E-02   AS3=5.75506952073839E-02   S33=2.84195075441441E-02   S22=7.7064281538524E-03   Z33=3.17708342163651E-02 _	");
			pw.println("	        Z22=1.17476847436693E-02   R33=0.359847732786063   R22=0.166979657176098   ConcCol=No   ConcBeam=No   Color=Red   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W10X45   	");
			pw.println("		");
			pw.println("	   SectionName=W10X49   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=0.831666628519694   t2=0.833333333333333   tf=4.66666668653488E-02   tw=2.83333336313566E-02   t2b=0.833333333333333   tfb=4.66666668653488E-02 _	");
			pw.println("	        Area=9.99999973509047E-02   TorsConst=6.70331783224771E-05   I33=1.31172839506173E-02   I22=4.50424390074647E-03   AS2=2.35638883378771E-02   AS3=6.48145808113946E-02   S33=3.15445720696166E-02   S22=1.08101853617915E-02 _	");
			pw.println("	        Z33=3.49537045867355E-02   Z22=1.63773143732989E-02   R33=0.362177916197366   R22=0.212232043293848   ConcCol=No   ConcBeam=No   Color=Magenta   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W10X49   	");
			pw.println("		");
			pw.println("	   SectionName=W12X30   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.02833334604899   t2=0.543333331743876   tf=3.66666664679845E-02   tw=2.16666658719381E-02   t2b=0.543333331743876   tfb=3.66666664679845E-02 _	");
			pw.println("	        Area=6.10416664017571E-02   TorsConst=2.2183642377732E-05   I33=1.14776234567901E-02   I22=9.78973728639108E-04   AS2=2.22805556323793E-02   AS3=3.32034726937612E-02   S33=2.23227681974699E-02   S22=3.60358428774103E-03 _	");
			pw.println("	        Z33=2.49421287465979E-02   Z22=5.53240765024115E-03   R33=0.433623485377112   R22=0.126640415908605   ConcCol=No   ConcBeam=No   Color=Yellow   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W12X30   	");
			pw.println("		");
			pw.println("	   SectionName=W12X35   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.04166666666667   t2=0.546666661898295   tf=4.33333317438761E-02   tw=2.50000009934107E-02   t2b=0.546666661898295   tfb=4.33333317438761E-02 _	");
			pw.println("	        Area=7.15277791023254E-02   TorsConst=3.56867288549741E-05   I33=0.013744212962963   I22=1.1815200617284E-03   AS2=2.60416666666667E-02   AS3=3.94812491205003E-02   S33=2.63888888888889E-02   S22=4.3226344098818E-03 _	");
			pw.println("	        Z33=2.96296300711455E-02   Z22=6.65509259259259E-03   R33=0.438351571232051   R22=0.128523688171445   ConcCol=No   ConcBeam=No   Color=White   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W12X35  	");
			pw.println("		");
			pw.println("	   SectionName=W12X40   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=0.994999965031942   t2=0.667083342870076   tf=4.29166654745738E-02   tw=2.45833322405815E-02   t2b=0.667083342870076   tfb=4.29166654745738E-02 _	");
			pw.println("	        Area=8.19444457689921E-02   TorsConst=4.58140426349861E-05   I33=1.49498456790123E-02   I22=2.12673603752513E-03   AS2=2.44604167011049E-02   AS3=4.77152764797211E-02   S33=3.00499421194099E-02   S22=6.3762228820615E-03 _	");
			pw.println("	        Z33=0.033275462962963   Z22=9.72222178070633E-03   R33=0.427128542452966   R22=0.16110055404312   ConcCol=No   ConcBeam=No   Color=Gray8Dark   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W12X40  	");
			pw.println("		");
			pw.println("	   SectionName=W12X45   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.00500003496806   t2=0.670416673024495   tf=4.79166656732559E-02   tw=2.79166673620542E-02   t2b=0.670416673024495   tfb=4.79166656732559E-02   Area=0.091666665342119 _	");
			pw.println("	        TorsConst=6.31751515615134E-05   I33=1.68788580246914E-02   I22=2.41126543209877E-03   AS2=2.80562506781684E-02   AS3=5.35402761565314E-02   S33=3.35897660445909E-02   S22=7.19333372548944E-03   Z33=3.74421278635661E-02 _	");
			pw.println("	        Z22=1.09953703703704E-02   R33=0.429107211887247   R22=0.162187281205422   ConcCol=No   ConcBeam=No   Color=Blue   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W12X45   	");
			pw.println("		");
			pw.println("	   SectionName=W12X50   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.01583329836527   t2=0.673333326975505   tf=5.33333321412404E-02   tw=3.08333337306976E-02   t2b=0.673333326975505   tfb=5.33333321412404E-02   Area=0.102083332008786 _	");
			pw.println("	        TorsConst=8.58410480029789E-05   I33=1.90007716049383E-02   I22=2.71508483975022E-03   AS2=3.13215288850996E-02   AS3=5.98520835240682E-02   S33=3.74092316830235E-02   S22=8.06460851105026E-03   Z33=4.18981490311799E-02 _	");
			pw.println("	        Z22=1.23842590385013E-02   R33=0.431427873431523   R22=0.163085099858054   ConcCol=No   ConcBeam=No   Color=Green   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W12X50 	");
			pw.println("		");
			pw.println("	   SectionName=W12X53   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.00500003496806   t2=0.832916657129923   tf=4.79166656732559E-02   tw=2.87499999006589E-02   t2b=0.832916657129923   tfb=4.79166656732559E-02   Area=0.108333335982429 _	");
			pw.println("	        TorsConst=7.61959897239267E-05   I33=2.04957561728395E-02   I22=4.6199847150732E-03   AS2=2.88937489191691E-02   AS3=6.65173596805996E-02   S33=0.040787573054146   S22=1.10935101982299E-02   Z33=4.50810194015503E-02 _	");
			pw.println("	        Z22=1.68402779985357E-02   R33=0.434961596943061   R22=0.206509108059889   ConcCol=No   ConcBeam=No   Color=Cyan   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W12X53  	");
			pw.println("		");
			pw.println("	   SectionName=W12X58   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.01583329836527   t2=0.834166685740153   tf=5.33333321412404E-02   tw=3.00000011920929E-02   t2b=0.834166685740153   tfb=5.33333321412404E-02   Area=0.118055555555556 _	");
			pw.println("	        TorsConst=1.01273143549024E-04   I33=2.29070216049383E-02   I22=5.16010802469136E-03   AS2=3.04750005404154E-02   AS3=7.41458336512248E-02   S33=4.50999620544065E-02   S22=1.23718870890002E-02   Z33=5.00000008830318E-02 _	");
			pw.println("	        Z22=1.88078703703704E-02   R33=0.440495116559104   R22=0.209067334432707   ConcCol=No   ConcBeam=No   Color=Red   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W12X58   	");
			pw.println("		");
			pw.println("	   SectionName=W12X65   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.00999999046326   t2=1   tf=5.04166682561239E-02   tw=3.24999988079071E-02   t2b=1   tfb=5.04166682561239E-02   Area=0.132638891537984   TorsConst=1.05131176058893E-04 _	");
			pw.println("	        I33=2.57040895061728E-02   I22=8.3912037037037E-03   AS2=3.28249997562832E-02   AS3=8.40277804268731E-02   S33=5.08991876215427E-02   S22=1.67824074074074E-02   Z33=5.60185202845821E-02   Z22=2.55208324503016E-02 _	");
			pw.println("	        R33=0.440215845139909   R22=0.251522412603521   ConcCol=No   ConcBeam=No   Color=Magenta   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1   SectInFile=W12X65 _	");
			pw.println("		");
			pw.println("	   ");
			pw.println("	SectionName=W12X72   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.02083333333333   t2=1.00333333015442   tf=5.58333347241084E-02   tw=3.58333339293798E-02   t2b=1.00333333015442   tfb=5.58333347241084E-02   Area=0.146527780426873 _	");
			pw.println("	        TorsConst=1.41300157540374E-04   I33=2.87905092592593E-02   I22=9.40393518518519E-03   AS2=0.036579860581292   AS3=9.33680534362793E-02   S33=0.05640589569161   S22=1.87453858105917E-02   Z33=0.0625   Z22=2.84722226637381E-02 _	");
			pw.println("	        R33=0.443266272740017   R22=0.253334786098568   ConcCol=No   ConcBeam=No   Color=Yellow   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1   SectInFile=W12X72 _	");
			pw.println("	 	");
			pw.println("	   	");
			pw.println("	SectionName=W14X22   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.14499998092651   t2=0.416666666666667   tf=2.79166673620542E-02   tw=1.91666670143604E-02   t2b=0.416666666666667   tfb=2.79166673620542E-02 _	");
			pw.println("	        Area=4.50694428549872E-02   TorsConst=1.01273144986251E-05   I33=9.59683641975309E-03   I22=3.37577160493827E-04   AS2=2.19458341598511E-02   AS3=1.93868047661251E-02   S33=1.67630333268434E-02   S22=1.62037037037037E-03 _	");
			pw.println("	        Z33=1.92129634044788E-02   Z22=2.54050918199398E-03   R33=0.461448194866607   R22=8.65456876995886E-02   ConcCol=No   ConcBeam=No   Color=White   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W14X22   	");
			pw.println("		");
			pw.println("	   SectionName=W14X26   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.15916665395101   t2=0.418750007947286   tf=3.49999989072482E-02   tw=2.12499996026357E-02   t2b=0.418750007947286   tfb=3.49999989072482E-02 _	");
			pw.println("	        Area=5.34027781751421E-02   TorsConst=1.73611118009797E-05   I33=1.18152006172839E-02   I22=4.29687492641402E-04   AS2=2.46326393551297E-02   AS3=2.44270828035143E-02   S33=2.03856806560333E-02   S22=0.002052238731876 _	");
			pw.println("	        Z33=2.32638893304048E-02   Z22=3.20601849644272E-03   R33=0.470368927532603   R22=0.089700410542482   ConcCol=No   ConcBeam=No   Color=Gray8Dark   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1 _	");
			pw.println("	        I2Mod=1   I3Mod=1   MMod=1   WMod=1   SectInFile=W14X26   	");
			pw.println("		");
			pw.println("	   SectionName=W14X30   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.15333334604899   t2=0.560833334922791   tf=3.20833325386047E-02   tw=2.25000008940697E-02   t2b=0.560833334922791   tfb=3.20833325386047E-02 _	");
			pw.println("	        Area=6.14583359824287E-02   TorsConst=1.83256170539944E-05   I33=1.40335648148148E-02   I22=9.45216067779211E-04   AS2=2.59499996900558E-02   AS3=2.99888882372114E-02   S33=2.43356612602766E-02   S22=3.37075565563284E-03 _	");
			pw.println("	        Z33=2.73726847436693E-02   Z22=5.20254616384153E-03   R33=0.477852215320513   R22=0.124015266006371   ConcCol=No   ConcBeam=No   Color=Blue   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W14X30   	");
			pw.println("		");
			pw.println("	   SectionName=W14X34   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.16499996185303   t2=0.56208332379659   tf=3.79166677594185E-02   tw=2.37499997019768E-02   t2b=0.56208332379659   tfb=3.79166677594185E-02   Area=6.94444444444444E-02 _	");
			pw.println("	        TorsConst=2.74884255809916E-05   I33=1.63966049382716E-02   I22=1.12364965456503E-03   AS2=2.76687492926915E-02   AS3=3.55208317438761E-02   S33=0.028148678927322   S22=3.99816043989829E-03   Z33=3.15972213391904E-02 _	");
			pw.println("	        Z22=6.1342594800172E-03   R33=0.485912657903775   R22=0.127202810604705   ConcCol=No   ConcBeam=No   Color=Green   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W14X34   	");
			pw.println("		");
			pw.println("	   SectionName=W14X38   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.17500003178914   t2=0.564166665077209   tf=4.29166654745738E-02   tw=2.58333335320155E-02   t2b=0.564166665077209   tfb=4.29166654745738E-02 _	");
			pw.println("	        Area=7.77777764532301E-02   TorsConst=3.85802474884707E-05   I33=1.85667438271605E-02   I22=1.28761577753373E-03   AS2=0.03035416536861   AS3=0.040353473689821   S33=3.16029673614381E-02   S22=4.5646645122413E-03 _	");
			pw.println("	        Z33=3.55902777777778E-02   Z22=7.00231503557276E-03   R33=0.488584979141884   R22=0.128666469131601   ConcCol=No   ConcBeam=No   Color=Cyan   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W14X38 	");
			pw.println("		");
			pw.println("	   SectionName=W14X43   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.13833332061768   t2=0.666249990463257   tf=4.41666642824809E-02   tw=2.54166672627131E-02   t2b=0.666249990463257   tfb=4.41666642824809E-02 _	");
			pw.println("	        Area=8.75000026490953E-02   TorsConst=5.06365717745122E-05   I33=2.06404320987654E-02   I22=2.17978398741027E-03   AS2=2.89326376385159E-02   AS3=4.90430560376909E-02   S33=0.036264302774807   S22=6.54344170690232E-03 _	");
			pw.println("	        Z33=0.040277776894746   Z22=1.00115736325582E-02   R33=0.48568574759369   R22=0.157834775144009   ConcCol=No   ConcBeam=No   Color=Red   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1 _	");
			pw.println("	        I3Mod=1   MMod=1   WMod=1   SectInFile=W14X43  	");
			pw.println("		");
			pw.println("	   SectionName=W14X48   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.14916666348775   t2=0.669166644414266   tf=4.95833357175191E-02   tw=2.83333336313566E-02   t2b=0.669166644414266   tfb=4.95833357175191E-02   Area=0.097916669315762 _	");
			pw.println("	        TorsConst=7.04089524569335E-05   I33=0.023389274691358   I22=2.47878093778351E-03   AS2=0.032559722661972   AS3=5.52993052535587E-02   S33=4.07064970373765E-02   S22=0.007408560957049   Z33=4.53703712534021E-02 _	");
			pw.println("	        Z22=1.13425928133505E-02   R33=0.488742449429928   R22=0.159107538766932   ConcCol=No   ConcBeam=No   Color=Magenta   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W14X48  	");
			pw.println("		");
			pw.println("	   SectionName=W14X53   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.16000000635783   t2=0.671666701634725   tf=5.50000021855036E-02   tw=3.08333337306976E-02   t2b=0.671666701634725   tfb=5.50000021855036E-02   Area=0.108333335982429 _	");
			pw.println("	        TorsConst=9.35571015249064E-05   I33=2.60898919753086E-02   I22=2.78260034543497E-03   AS2=3.57666677898831E-02   AS3=6.15694456630283E-02   S33=4.49825721246774E-02   S22=8.28565816546385E-03   Z33=5.04050917095608E-02 _	");
			pw.println("	        Z22=1.27314814814815E-02   R33=0.490744094402283   R22=0.160267092761039   ConcCol=No   ConcBeam=No   Color=Yellow   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W14X53   	");
			pw.println("		");
			pw.println("	   SectionName=W14X61   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.15750002861023   t2=0.832916657129923   tf=5.37499984105428E-02   tw=0.03125   t2b=0.832916657129923   tfb=5.37499984105428E-02   Area=0.12430555290646 _	");
			pw.println("	        TorsConst=1.06095681311908E-04   I33=3.08641975308642E-02   I22=5.16010802469136E-03   AS2=0.036172221104304   AS3=0.074618054760827   S33=5.33290656898243E-02   S22=1.23904546283709E-02   Z33=5.90277777777778E-02 _	");
			pw.println("	        Z22=1.89814810399656E-02   R33=0.498290067144193   R22=0.203743673362506   ConcCol=No   ConcBeam=No   Color=White   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W14X61  	");
			pw.println("		");
			pw.println("	   SectionName=W14X68   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.16999999682109   t2=0.836249987284342   tf=6.00000023841858E-02   tw=3.45833326379458E-02   t2b=0.836249987284342   tfb=6.00000023841858E-02   Area=0.138888888888889 _	");
			pw.println("	        TorsConst=1.45640431178941E-04   I33=3.48668981481481E-02   I22=5.83526234567901E-03   AS2=4.04625005192227E-02   AS3=8.36249987284342E-02   S33=5.96015354579184E-02   S22=1.39557845964903E-02   Z33=6.65509259259259E-02 _	");
			pw.println("	        Z22=2.13541675496984E-02   R33=0.501040583851914   R22=0.204972897937481   ConcCol=No   ConcBeam=No   Color=Gray8Dark   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1 _	");
			pw.println("	        WMod=1   SectInFile=W14X68   	");
			pw.println("		");
			pw.println("	   SectionName=W14X74   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.18083333969116   t2=0.839166641235352   tf=6.54166688521703E-02   tw=3.74999990065892E-02   t2b=0.839166641235352   tfb=6.54166688521703E-02   Area=0.151388883590698 _	");
			pw.println("	        TorsConst=1.87114203049813E-04   I33=3.83873456790123E-02   I22=6.46219135802469E-03   AS2=4.42812509006924E-02   AS3=9.14930568801032E-02   S33=6.50173811810772E-02   S22=1.54014495821988E-02   Z33=7.29166666666667E-02 _	");
			pw.println("	        Z22=2.34953694873386E-02   R33=0.503555157699359   R22=0.206605992537497   ConcCol=No   ConcBeam=No   Color=Blue   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W14X74  	");
			pw.println("		");
			pw.println("	   SectionName=W14X82   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.19250003496806   t2=0.84416667620341   tf=7.12500015894572E-02   tw=4.24999992052714E-02   t2b=0.84416667620341   tfb=7.12500015894572E-02   Area=0.167361113760206 _	");
			pw.println("	        TorsConst=2.44984564221936E-04   I33=4.25347222222222E-02   I22=7.13734567901235E-03   AS2=5.06812499629127E-02   AS3=0.10024305846956   S33=7.13370582389317E-02   S22=1.69098020099825E-02   Z33=8.04398148148148E-02 _	");
			pw.println("	        Z22=0.02592592548441   R33=0.504132297686359   R22=0.206510000110458   ConcCol=No   ConcBeam=No   Color=Green   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W14X82   	");
			pw.println("		");
			pw.println("	   SectionName=W14X90   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.16833337148031   t2=1.21000003814697   tf=5.91666648785273E-02   tw=3.66666664679845E-02   t2b=1.21000003814697   tfb=5.91666648785273E-02   Area=0.184027777777778 _	");
			pw.println("	        TorsConst=1.95794750326945E-04   I33=4.81770833333333E-02   I22=1.74575617283951E-02   AS2=4.28388880358802E-02   AS3=0.119319438934326   S33=8.24714666367731E-02   S22=2.88554730215216E-02   Z33=9.08564814814815E-02 _	");
			pw.println("	        Z22=4.37499991169682E-02   R33=0.511656577041856   R22=0.307999564376615   ConcCol=No   ConcBeam=No   Color=Cyan   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W14X90   	");
			pw.println("		");
			pw.println("	   SectionName=W14X99   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.17999998728434   t2=1.21374996503194   tf=6.49999976158142E-02   tw=4.04166678587596E-02   t2b=1.21374996503194   tfb=6.49999976158142E-02   Area=0.202083335982429 _	");
			pw.println("	        TorsConst=2.58969901888459E-04   I33=5.35300925925926E-02   I22=1.93865740740741E-02   AS2=4.76916664176517E-02   AS3=0.131486111217075   S33=9.07289714736133E-02   S22=3.19449221546447E-02   Z33=0.100115740740741 _	");
			pw.println("	        Z22=4.83796287465979E-02   R33=0.514675797339641   R22=0.309731433940473   ConcCol=No   ConcBeam=No   Color=Red   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W14X99   	");
			pw.println("		");
			pw.println("	   SectionName=W16X50   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.35500001907349   t2=0.589166680971781   tf=5.24999996026357E-02   tw=3.16666662693024E-02   t2b=0.589166680971781   tfb=5.24999996026357E-02   Area=0.102083332008786 _	");
			pw.println("	        TorsConst=7.33024682159777E-05   I33=3.17804783950617E-02   I22=1.79398151827447E-03   AS2=4.29083340697818E-02   AS3=5.15520837571886E-02   S33=4.69084545353621E-02   S22=6.08989468079033E-03   Z33=5.32407407407407E-02 _	");
			pw.println("	        Z22=9.43286992885448E-03   R33=0.557959654520532   R22=0.132565820382055   ConcCol=No   ConcBeam=No   Color=Magenta   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W16X50   	");
			pw.println("		");
			pw.println("	   SectionName=W16X57   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.36916669209798   t2=0.59333332379659   tf=5.95833311478297E-02   tw=3.58333339293798E-02   t2b=0.59333332379659   tfb=5.95833311478297E-02   Area=0.116666661368476 _	");
			pw.println("	        TorsConst=1.07060186564922E-04   I33=3.65547839506173E-02   I22=2.07851072888315E-03   AS2=4.90618050098419E-02   AS3=5.89215291870965E-02   S33=5.33971271162084E-02   S22=7.00621605266763E-03   Z33=6.07638888888889E-02 _	");
			pw.println("	        Z22=1.09374997792421E-02   R33=0.559755959151706   R22=0.133475866944704   ConcCol=No   ConcBeam=No   Color=Yellow   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W16X57  	");
			pw.println("		");
			pw.println("	   SectionName=W16X67   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.3608333269755   t2=0.852916638056437   tf=0.055416668454806   tw=3.29166675607363E-02   t2b=0.852916638056437   tfb=0.055416668454806   Area=0.136805560853746 _	");
			pw.println("	        TorsConst=1.15258492713357E-04   I33=4.60069444444444E-02   I22=5.73881172839506E-03   AS2=4.47944435808394E-02   AS3=7.87777768241035E-02   S33=6.76158402832422E-02   S22=1.34569111970245E-02   Z33=7.52314814814815E-02 _	");
			pw.println("	        Z22=2.05439814814815E-02   R33=0.579908961147939   R22=0.20481375182908   ConcCol=No   ConcBeam=No   Color=White   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W16X67   	");
			pw.println("		");
			pw.println("	   SectionName=W16X77   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.37666670481364   t2=0.857916673024495   tf=6.33333325386047E-02   tw=3.79166677594185E-02   t2b=0.857916673024495   tfb=6.33333325386047E-02   Area=0.15694444709354 _	");
			pw.println("	        TorsConst=1.72164348632465E-04   I33=5.35300925925926E-02   I22=6.65509259259259E-03   AS2=5.21986120276981E-02   AS3=0.090555555290646   S33=0.077767686841586   S22=1.55145430829098E-02   Z33=8.68055555555556E-02 _	");
			pw.println("	        Z22=2.37847213391904E-02   R33=0.584017714121835   R22=0.205922628862791   ConcCol=No   ConcBeam=No   Color=Gray8Dark   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1 _	");
			pw.println("	        WMod=1   SectInFile=W16X77   	");
			pw.println("		");
			pw.println("	   SectionName=W16X89   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.39583333333333   t2=0.863749980926514   tf=7.29166666666667E-02   tw=4.37499980131785E-02   t2b=0.863749980926514   tfb=7.29166666666667E-02   Area=0.181944449742635 _	");
			pw.println("	        TorsConst=2.62827922900518E-04   I33=6.26929012345679E-02   I22=7.86072530864198E-03   AS2=0.061068058013916   AS3=0.104972223440806   S33=0.089828634604754   S22=0.018201390407465   Z33=0.101273148148148   Z22=2.78356472651164E-02 _	");
			pw.println("	        R33=0.587002266497909   R22=0.207855683518841   ConcCol=No   ConcBeam=No   Color=Yellow   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1   SectInFile=W16X89 _	");
			pw.println("		");
			pw.println("	   ");
			pw.println("	SectionName=W18X106   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.56083329518636   t2=0.933333317438761   tf=7.83333331346512E-02   tw=0.049166664481163   t2b=0.933333317438761   tfb=7.83333331346512E-02   Area=0.215972224871318 _	");
			pw.println("	        TorsConst=3.607253095618E-04   I33=9.21103395061728E-02   I22=1.06095679012346E-02   AS2=0.076743053065406   AS3=0.121854172812568   S33=0.118027133058018   S22=2.27347887469595E-02   Z33=0.133101851851852   Z22=3.50115740740741E-02 _	");
			pw.println("	        R33=0.653063242659569   R22=0.221640896013786   ConcCol=No   ConcBeam=No   Color=Green   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1   SectInFile=W18X106 _	");
			pw.println("		");
			pw.println("		");
			pw.println("	   SectionName=W18X119   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.58083327611287   t2=0.938750028610229   tf=8.83333285649617E-02   tw=5.45833309491475E-02   t2b=0.938750028610229   tfb=8.83333285649617E-02   Area=0.243749989403619 _	");
			pw.println("	        TorsConst=5.11188290001434E-04   I33=0.105613425925926   I22=1.22010030864198E-02   AS2=8.62847235467699E-02   AS3=0.138201382425096   S33=0.133617412439115   S22=2.59941469285124E-02   Z33=0.151041666666667 _	");
			pw.println("	        Z22=3.99884250428941E-02   R33=0.658244535707258   R22=0.223730640399666   ConcCol=No   ConcBeam=No   Color=Cyan   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W18X119   	");
			pw.println("		");
			pw.println("	   SectionName=W18X130   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.60416666666667   t2=0.929999987284342   tf=0.100000003973643   tw=5.58333347241084E-02   t2b=0.929999987284342   tfb=0.100000003973643   Area=0.265277783075968 _	");
			pw.println("	        TorsConst=7.08912027838789E-04   I33=0.118634259259259   I22=1.34066358024691E-02   AS2=8.95694428020053E-02   AS3=0.154999997880724   S33=0.147907647907648   S22=2.88314752382252E-02   Z33=0.168402777777778 _	");
			pw.println("	        Z22=4.43865723080105E-02   R33=0.66873587458079   R22=0.224806811594346   ConcCol=No   ConcBeam=No   Color=Cyan   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W18X130   	");
			pw.println("		");
			pw.println("	   SectionName=W18X60   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.51999998092651   t2=0.629583319028219   tf=5.79166660706202E-02   tw=3.45833326379458E-02   t2b=0.629583319028219   tfb=5.79166660706202E-02   Area=0.122222224871318 _	");
			pw.println("	        TorsConst=1.04648923432385E-04   I33=4.74537037037037E-02   I22=2.41608788937698E-03   AS2=0.052566667397817   AS3=6.07722202936808E-02   S33=0.06243908460417   S22=7.67519664627166E-03   Z33=7.11805555555556E-02 _	");
			pw.println("	        Z22=1.19212965170542E-02   R33=0.623103175519367   R22=0.14059868916073   ConcCol=No   ConcBeam=No   Color=Red   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W18X60  	");
			pw.println("		");
			pw.println("	   SectionName=W18X65   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.52916669845581   t2=0.632500012715657   tf=0.0625   tw=3.74999990065892E-02   t2b=0.632500012715657   tfb=0.0625   Area=0.132638891537984 _	");
			pw.println("	        TorsConst=1.31655093512417E-04   I33=5.16010802469136E-02   I22=2.64274687678726E-03   AS2=5.73437478807237E-02   AS3=6.58854179912143E-02   S33=6.74891498736163E-02   S22=8.35651169536122E-03   Z33=7.69675925925926E-02 _	");
			pw.println("	        Z22=1.30208333333333E-02   R33=0.623726153460403   R22=0.14115372457392   ConcCol=No   ConcBeam=No   Color=Magenta   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W18X65  	");
			pw.println("		");
			pw.println("	   SectionName=W18X71   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.53916660944621   t2=0.636250019073486   tf=6.75000001986821E-02   tw=4.12500003973643E-02   t2b=0.636250019073486   tfb=6.75000001986821E-02   Area=0.144444439146254 _	");
			pw.println("	        TorsConst=1.67824074993899E-04   I33=5.64236111111111E-02   I22=2.90798607431812E-03   AS2=6.34902781910366E-02   AS3=7.15763900015089E-02   S33=7.33170935034932E-02   S22=9.14101685545804E-03   Z33=0.083912037037037 _	");
			pw.println("	        Z22=1.42939819229974E-02   R33=0.625000011462432   R22=0.141888026352423   ConcCol=No   ConcBeam=No   Color=Yellow   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W18X71  	");
			pw.println("		");
			pw.println("	   SectionName=W18X76   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.51749992370605   t2=0.919583320617676   tf=5.66666672627131E-02   tw=3.54166676600774E-02   t2b=0.919583320617676   tfb=5.66666672627131E-02   Area=0.15486110581292 _	");
			pw.println("	        TorsConst=1.36477619777491E-04   I33=6.41396604938272E-02   I22=7.33024691358025E-03   AS2=5.37444452444712E-02   AS3=8.68472192022536E-02   S33=8.45333294477994E-02   S22=1.59425399509347E-02   Z33=9.43287037037037E-02 _	");
			pw.println("	        Z22=2.44212967378122E-02   R33=0.643564604619046   R22=0.217564545514585   ConcCol=No   ConcBeam=No   Color=White   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W18X76  	");
			pw.println("		");
			pw.println("	   SectionName=W18X86   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.53249994913737   t2=0.924166679382324   tf=6.41666650772095E-02   tw=3.99999991059303E-02   t2b=0.924166679382324   tfb=6.41666650772095E-02   Area=0.175694439146254 _	");
			pw.println("	        TorsConst=1.97723760832975E-04   I33=7.37847222222222E-02   I22=8.43942901234568E-03   AS2=0.061299999554952   AS3=0.098833335770501   S33=0.096293278526704   S22=1.82638677646034E-02   Z33=0.107638888888889   Z22=0.028009260142291 _	");
			pw.println("	        R33=0.64804358416121   R22=0.219168191629957   ConcCol=No   ConcBeam=No   Color=Gray8Dark   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1   SectInFile=W18X86 _	");
			pw.println("		");
			pw.println("		");
			pw.println("	   SectionName=W18X97   Material=A992Fy50   Shape=\"I/Wide Flange\"   t3=1.54916667938232   t2=0.928750038146973   tf=7.25000003973643E-02   tw=0.044583335518837   t2b=0.928750038146973   tfb=7.25000003973643E-02   Area=0.197916666666667 _	");
			pw.println("	        TorsConst=2.82600315080749E-04   I33=8.43942901234568E-02   I22=9.69328703703704E-03   AS2=6.90673589706421E-02   AS3=0.112222221162584   S33=0.108954434983208   S22=2.08738339464878E-02   Z33=0.122106481481481 _	");
			pw.println("	        Z22=3.20023143732989E-02   R33=0.653003258307816   R22=0.221306593184963   ConcCol=No   ConcBeam=No   Color=Blue   TotalWt=0   TotalMass=0   FromFile=Yes   AMod=1   A2Mod=1   A3Mod=1   JMod=1   I2Mod=1   I3Mod=1   MMod=1   WMod=1 _	");
			pw.println("	        SectInFile=W18X97  	");
			pw.println("	 	");
			pw.println("	TABLE:  \"FRAME SECTION PROPERTIES 04 - AUTO SELECT\"	");

			pw.println("	   ListName=Beams   SectionName=W10X22	");
			pw.println("	   ListName=Beams   SectionName=W10X26	");
			pw.println("	   ListName=Beams   SectionName=W10X30	");
			pw.println("	   ListName=Beams   SectionName=W10X33	");
			pw.println("	   ListName=Beams   SectionName=W10X39	");
			pw.println("	   ListName=Beams   SectionName=W10X45	");
			pw.println("	   ListName=Beams   SectionName=W10X49	");
			pw.println("	   ListName=Beams   SectionName=W12X30	");
			pw.println("	   ListName=Beams   SectionName=W12X35	");
			pw.println("	   ListName=Beams   SectionName=W12X40	");
			pw.println("	   ListName=Beams   SectionName=W12X45	");
			pw.println("	   ListName=Beams   SectionName=W12X50	");
			pw.println("	   ListName=Beams   SectionName=W12X53	");
			pw.println("	   ListName=Beams   SectionName=W12X58	");
			pw.println("	   ListName=Beams   SectionName=W12X65	");
			pw.println("	   ListName=Beams   SectionName=W12X72	");
			pw.println("	   ListName=Beams   SectionName=W14X22	");
			pw.println("	   ListName=Beams   SectionName=W14X26	");
			pw.println("	   ListName=Beams   SectionName=W14X30	");
			pw.println("	   ListName=Beams   SectionName=W14X34	");
			pw.println("	   ListName=Beams   SectionName=W14X38	");
			pw.println("	   ListName=Beams   SectionName=W14X43	");
			pw.println("	   ListName=Beams   SectionName=W14X48	");
			pw.println("	   ListName=Beams   SectionName=W14X53	");
			pw.println("	   ListName=Beams   SectionName=W14X61	");
			pw.println("	   ListName=Beams   SectionName=W14X68	");
			pw.println("	   ListName=Beams   SectionName=W14X74	");
			pw.println("	   ListName=Beams   SectionName=W14X82	");
			pw.println("	   ListName=Beams   SectionName=W14X90	");
			pw.println("	   ListName=Beams   SectionName=W14X99	");
			pw.println("	   ListName=Beams   SectionName=W16X50	");
			pw.println("	   ListName=Beams   SectionName=W16X57	");
			pw.println("	   ListName=Beams   SectionName=W16X67	");
			pw.println("	   ListName=Beams   SectionName=W16X77	");
			pw.println("	   ListName=Beams   SectionName=W16X89	");
			pw.println("	   ListName=COLS   SectionName=W14X22	");
			pw.println("	   ListName=COLS   SectionName=W14X26	");
			pw.println("	   ListName=COLS   SectionName=W14X30	");
			pw.println("	   ListName=COLS   SectionName=W14X34	");
			pw.println("	   ListName=COLS   SectionName=W14X38	");
			pw.println("	   ListName=COLS   SectionName=W14X43	");
			pw.println("	   ListName=COLS   SectionName=W14X48	");
			pw.println("	   ListName=COLS   SectionName=W14X53	");
			pw.println("	   ListName=COLS   SectionName=W14X61	");
			pw.println("	   ListName=COLS   SectionName=W14X68	");
			pw.println("	   ListName=COLS   SectionName=W14X74	");
			pw.println("	   ListName=COLS   SectionName=W14X82	");
			pw.println("	   ListName=COLS   SectionName=W14X90	");
			pw.println("	   ListName=COLS   SectionName=W14X99	");
			pw.println("	   ListName=COLS   SectionName=W16X50	");
			pw.println("	   ListName=COLS   SectionName=W16X57	");
			pw.println("	   ListName=COLS   SectionName=W16X67	");
			pw.println("	   ListName=COLS   SectionName=W16X77	");
			pw.println("	   ListName=COLS   SectionName=W16X89	");
			pw.println("	   ListName=COLS   SectionName=W18X60	");
			pw.println("	   ListName=COLS   SectionName=W18X65	");
			pw.println("	   ListName=COLS   SectionName=W18X71	");
			pw.println("	   ListName=COLS   SectionName=W18X76	");
			pw.println("	   ListName=COLS   SectionName=W18X86	");
			pw.println("	   ListName=COLS   SectionName=W18X97	");
			pw.println("");
			pw.println("");
			pw.println("");
			pw.println("");
			pw.println("TABLE:  \"HINGES DEF 01 - OVERVIEW\"");
			pw.println("");
			pw.println("TABLE:  \"HINGES DEF 02 - NONINTERACTING - DEFORM CONTROL - GENERAL\"");
			pw.println("");
			pw.println("TABLE:  \"HINGES DEF 03 - NONINTERACTING - DEFORM CONTROL - FORCE-DEFORM\"");
			pw.println("");
			pw.println("TABLE:  \"HINGES DEF 04 - NONINTERACTING - DEFORM CONTROL - ACCEPTANCE\"");
			pw.println("");
			pw.println("TABLE:  \"HINGES GEN 01 - OVERVIEW\"");
			// Enter Hinges Here if Desired

			/*
			 * LOAD CASES
			 */
			pw.println("TABLE:  \"LOAD CASE DEFINITIONS\"");
			pw.println("   LoadCase=DEAD   DesignType=DEAD   SelfWtMult=1");
			// pw.println("   LoadCase=LR   DesignType=LIVE   SelfWtMult=0");
			pw.println("   LoadCase=LL   DesignType=LIVE   SelfWtMult=0");
			pw.println("   LoadCase=SDL   DesignType=DEAD   SelfWtMult=0");
			// pw.println("   LoadCase=SDL_R   DesignType=DEAD   SelfWtMult=0");
			pw.println("   LoadCase=COL_EQUIV   DesignType=OTHER   SelfWtMult=0");
			pw.println("   LoadCase=COL_CANCEL   DesignType=OTHER   SelfWtMult=0");
			pw.println("");
			pw.println("TABLE:  \"GROUPS 1 - DEFINITIONS\"");
			pw.println("   GroupName=Beams   Selection=Yes   SectionCut=Yes   Steel=Yes   Concrete=No   Aluminum=No   ColdFormed=No   Stage=Yes   Bridge=No   AutoSeismic=No   AutoWind=No   SelDesSteel=No   SelDesAlum=No   SelDesCold=No   MassWeight=No   Color=Yellow");
			pw.println("   GroupName=COLS   Selection=Yes   SectionCut=Yes   Steel=Yes   Concrete=No   Aluminum=No   ColdFormed=No   Stage=Yes   Bridge=No   AutoSeismic=No   AutoWind=No   SelDesSteel=No   SelDesAlum=No   SelDesCold=No   MassWeight=No   Color=White");
			pw.println("");

			pw.println("TABLE:  \"GROUPS 2 - ASSIGNMENTS\"");
			pw.println("");
			double FramesZDir = numstorys * (bays + 1);
			double totFrames = (numstorys * (bays + 1) + numstorys * bays);

			for (int ff = 1; ff <= (totFrames + 1); ff++) {

				if (ff <= (numstorys * (bays + 1))) {
					pw.println("   GroupName=COLS   ObjectType=Frame   ObjectLabel="
							+ ff + "");
				} else if (ff > (numstorys * (bays + 1))
						&& (ff <= totFrames + 1)) {
					pw.println("   GroupName=Beams   ObjectType=Frame   ObjectLabel="
							+ ff + "");
				}
			}

			pw.println("");
			pw.println("TABLE:  \"AUTO WAVE 3 - WAVE CHARACTERISTICS - GENERAL\"");
			pw.println("   WaveChar=Default   WaveType=\"From Theory\"   KinFactor=1   SWaterDepth=150   WaveHeight=60   WavePeriod=12   WaveTheory=Linear");

			/*
			 * COMBINATIONS
			 */
			pw.println("TABLE:  \"COMBINATION DEFINITIONS\"");
			pw.println(" ComboName=UDSTL1   ComboType=\"Linear Add\"   AutoDesign=No   CaseType=\"Linear Static\"   CaseName=DEAD   ScaleFactor=1.4   SteelDesign=Yes   ConcDesign=No   AlumDesign=No   ColdDesign=No");
			pw.println("   ComboName=UDSTL1   CaseType=\"Linear Static\"   CaseName=SDL   ScaleFactor=1.4");
			// pw.println("   ComboName=UDSTL1   CaseType=\"Linear Static\"   CaseName=SDL_R   ScaleFactor=1.4");
			pw.println("ComboName=UDSTL2   ComboType=\"Linear Add\"   AutoDesign=No   CaseType=\"Linear Static\"   CaseName=DEAD   ScaleFactor=1.2   SteelDesign=Yes   ConcDesign=No   AlumDesign=No   ColdDesign=No");
			pw.println("   ComboName=UDSTL2   CaseType=\"Linear Static\"   CaseName=LL   ScaleFactor=1.6");
			// pw.println("   ComboName=UDSTL2   CaseType=\"Linear Static\"   CaseName=LR   ScaleFactor=1.6");
			pw.println("   ComboName=UDSTL2   CaseType=\"Linear Static\"   CaseName=SDL   ScaleFactor=1.2");
			// pw.println("   ComboName=UDSTL2   CaseType=\"Linear Static\"   CaseName=SDL_R   ScaleFactor=1.2");
			pw.println("");

			/*
			 * RAMP FUNCTION
			 */
			pw.println("TABLE:  \"FUNCTION - TIME HISTORY - RAMP\"");
			pw.println("   Name=COL_REM   Time=0   Value=0   RampTime=0.3333   Amplitude=1   MaxTime=5");
			pw.println("   Name=COL_REM   Time=0.3333   Value=1");
			pw.println("   Name=COL_REM   Time=5   Value=1");
			pw.println("");

			/*
			 * CASE DEFINITIONS
			 */
			pw.println("TABLE:  \"ANALYSIS CASE DEFINITIONS\"");
			pw.println("   Case=DEAD   Type=LinStatic   InitialCond=Zero   RunCase=Yes");
			pw.println("   Case=LL   Type=LinStatic   InitialCond=Zero   RunCase=Yes");
			// pw.println("   Case=LR   Type=LinStatic   InitialCond=Zero   RunCase=Yes");
			pw.println("   Case=SDL   Type=LinStatic   InitialCond=Zero   RunCase=Yes");
			// pw.println("   Case=SDL_R   Type=LinStatic   InitialCond=Zero   RunCase=Yes");
			pw.println("   Case=COL_EQUIV   Type=LinStatic   InitialCond=Zero   RunCase=Yes");
			pw.println("   Case=COL_CANCEL   Type=LinStatic   InitialCond=Zero   RunCase=Yes");
			pw.println("   Case=NLD_PC   Type=NonDirHist   InitialCond=NLS_PC   RunCase=Yes");
			pw.println("   Case=NLS_PC   Type=NonStatic   InitialCond=Zero   RunCase=Yes");

			/*
			 * LOAD ASSIGNMENTS
			 */
			pw.println("TABLE:  \"CASE - STATIC 1 - LOAD ASSIGNMENTS\"");
			pw.println("   Case=DEAD   LoadType=\"Load case\"   LoadName=DEAD   LoadSF=1");
			pw.println("   Case=LL   LoadType=\"Load case\"   LoadName=LL   LoadSF=1");
			// pw.println("   Case=LR   LoadType=\"Load case\"   LoadName=LR   LoadSF=1");
			pw.println("   Case=SDL   LoadType=\"Load case\"   LoadName=SDL   LoadSF=1");
			// pw.println("   Case=SDL_R   LoadType=\"Load case\"   LoadName=SDL_R   LoadSF=1");
			pw.println("   Case=COL_EQUIV   LoadType=\"Load case\"   LoadName=COL_EQUIV   LoadSF=1");
			pw.println("   Case=COL_CANCEL   LoadType=\"Load case\"   LoadName=COL_CANCEL   LoadSF=1");
			pw.println("   Case=NLS_PC   LoadType=\"Load case\"   LoadName=DEAD   LoadSF=1.2");
			pw.println("   Case=NLS_PC   LoadType=\"Load case\"   LoadName=SDL   LoadSF=1.2");
			// pw.println("   Case=NLS_PC   LoadType=\"Load case\"   LoadName=SDL_R   LoadSF=1.2");
			pw.println("   Case=NLS_PC   LoadType=\"Load case\"   LoadName=LL   LoadSF=0.5");
			pw.println("   Case=NLS_PC   LoadType=\"Load case\"   LoadName=LR   LoadSF=0.5");

			/*
			 * NON LINEAR DATA
			 */
			pw.println("TABLE:  \"CASE - STATIC 2 - NONLINEAR LOAD APPLICATION\"");
			pw.println("   Case=NLS_PC   LoadApp=\"Full Load\"   MonitorDOF=U1");
			pw.println("");
			pw.println("TABLE:  \"CASE - STATIC 4 - NONLINEAR PARAMETERS\"");
			pw.println("   Case=NLS_PC   Unloading=\"Unload Entire\"   GeoNonLin=P-Delta   ResultsSave=\"Final State\"   MaxTotal=200   MaxNull=50   MaxIterCS=10   MaxIterNR=40   ItConvTol=0.0001   UseEvStep=Yes   EvLumpTol=0.01   LSPerIter=20   LSTol=0.1 _");
			pw.println("        LSStepFact=1.618   FrameTC=Yes   FrameHinge=Yes   CableTC=Yes   LinkTC=Yes   LinkOther=Yes   TFMaxIter=10   TFTol=0.01   TFAccelFact=1   TFNoStop=No");

			/*
			 * NON LINEAR DYNAMIC DATA
			 */
			pw.println("TABLE:  \"CASE - DIRECT HISTORY 1 - GENERAL\"");
			pw.println("   Case=NLD_PC   OutSteps=20   StepSize=0.02");
			pw.println("");
			pw.println("TABLE:  \"CASE - DIRECT HISTORY 2 - LOAD ASSIGNMENTS\"");
			pw.println("   Case=NLD_PC   LoadType=\"Load case\"   LoadName=COL_CANCEL   Function=COL_REM   LoadSF=1   TimeFactor=1   ArrivalTime=0");
			pw.println("");
			pw.println("TABLE:  \"CASE - DIRECT HISTORY 3 - PROPORTIONAL DAMPING\"");
			pw.println("   Case=NLD_PC   SpecifyType=Period   MassCoeff=0.228479465715621   StiffCoeff=5.78745247606892E-04   Period1=1   Damping1=0.02   Period2=0.1   Damping2=0.02");
			pw.println("");
			pw.println("TABLE:  \"CASE - DIRECT HISTORY 4 - INTEGRATION PARAMETERS\"");
			pw.println("   Case=NLD_PC   IntMethod=HilberHughesTaylor   Gamma=0   Beta=0   Alpha=0");
			pw.println("");
			pw.println("TABLE:  \"CASE - DIRECT HISTORY 5 - NONLINEAR PARAMETERS\"");
			pw.println("   Case=NLD_PC   GeoNonLin=P-Delta   DTMax=0   DTMin=0   MaxIterCS=10   MaxIterNR=40   ItConvTol=0.0001   UseEvStep=Yes   EvLumpTol=0.01   LSPerIter=20   LSTol=0.1   LSStepFact=1.618   FrameTC=Yes   FrameHinge=Yes   CableTC=Yes   LinkTC=Yes   LinkOther=Yes");

			/*
			 * JOINT/NODE DATA
			 */
			pw.println("TABLE:  \"JOINT COORDINATES\"");

			double nodesX = (bays + 1);

			double x = numstorys;

			int joint = 0;

			for (int i = 0; i <= (nodesX - 1); i++) {

				for (int j = 0; j <= x; j++) {

					joint++;

					pw.println("Joint="
							+ (joint)
							+ "   CoordSys=GLOBAL   CoordType=Cartesian   XorR="
							+ (-width1 * bays * 0.5 + (i * width))
							+ "   Y=0   Z=" + (j * colhgt)
							+ "   SpecialJt=No   GlobalX="
							+ (-width1 * bays * 0.5 + (i * width))
							+ "   GlobalY=0   GlobalZ=" + (j * colhgt) + "");
				}

			}

			pw.println("TABLE:  \"CONNECTIVITY - FRAME\"");

			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			int e = 0;
			int f = 0;
			int g = 0;
			int h = 0;
			int i = 0;
			int j = 0;
			int k = 0;

			for (int l = 1; l <= (numstorys * (bays + 1)); l++) {

				if (l <= numstorys) {
					a++;
					pw.println("   Frame=" + (l) + "   JointI=" + l
							+ "   JointJ=" + (l + 1)
							+ "   IsCurved=No   Length=" + colhgt
							+ "   CentroidX=" + (-width1 * bays * 0.5)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (a - 1))) + "");
				} else if ((l > numstorys) && (l <= (2 * numstorys))) {
					b++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 1)
							+ "   JointJ=" + (l + 2)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX="
							+ (-width1 * bays * 0.5 + width)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (b - 1))) + "");

				} else if (l <= (3 * numstorys)) {
					c++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 2)
							+ "   JointJ=" + (l + 3)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX="
							+ (-width1 * bays * 0.5 + 2 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (c - 1))) + "");
				} else if (l <= (4 * numstorys)) {
					d++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 3)
							+ "   JointJ=" + (l + 4)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX="
							+ (-width1 * bays * 0.5 + 3 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (d - 1))) + "");
				} else if (l <= (5 * numstorys)) {
					e++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 4)
							+ "   JointJ=" + (l + 5)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX=" + (-120 + 4 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (e - 1))) + "");
				} else if (l <= (6 * numstorys)) {
					f++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 5)
							+ "   JointJ=" + (l + 6)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX="
							+ (-width1 * bays * 0.5 + 5 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (f - 1))) + "");
				} else if (l <= (7 * numstorys)) {
					g++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 6)
							+ "   JointJ=" + (l + 7)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX="
							+ (-width1 * bays * 0.5 + 6 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (g - 1))) + "");

				} else if (l <= (8 * numstorys)) {
					h++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 7)
							+ "   JointJ=" + (l + 8)
							+ "   IsCurved=No   Length=" + colhgt
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + 7 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (h - 1))) + "");
				} else if (l <= (9 * numstorys)) {
					i++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 8)
							+ "   JointJ=" + (l + 9)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX="
							+ (-width1 * bays * 0.5 + 8 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (i - 1))) + "");
				} else if (l <= (10 * numstorys)) {
					j++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 9)
							+ "   JointJ=" + (l + 10)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX="
							+ (-width1 * bays * 0.5 + 9 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (j - 1))) + "");
				} else if (l <= (11 * numstorys)) {
					k++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 10)
							+ "   JointJ=" + (l + 11)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX="
							+ (-width1 * bays * 0.5 + 10 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (colhgt / 2 + (colhgt * (k - 1))) + "");
				}
			}

			int q = -1;
			int r = -1;
			int p = -1;
			int v = -1;
			int t = -1;
			int u = -1;
			int w = -1;
			int y = -1;
			int aa = -1;
			int bb = -1;

			for (int s = (int) (FramesZDir + 2); s <= totFrames + 1; s++) {

				q++;
				int zCent = (int) (colhgt + colhgt * q);

				if (zCent <= numstorys * colhgt) {
					pw.println("   Frame=" + (s - 1) + "   JointI=" + (2 + q)
							+ "   JointJ=" + (numstorys + 3 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + width * 0.5)
							+ "    CentroidY=0   CentroidZ=" + zCent + "");
				} else if ((zCent > numstorys * colhgt)
						&& (zCent <= 2 * numstorys * colhgt)) {

					r++;
					double hgtRest = (colhgt + colhgt * r);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (3 + q)
							+ "   JointJ=" + (numstorys + 4 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + width * 1.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > numstorys * colhgt)
						&& (zCent <= 3 * numstorys * colhgt)) {

					p++;
					double hgtRest = (colhgt + colhgt * p);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (4 + q)
							+ "   JointJ=" + (numstorys + 5 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + width * 2.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > numstorys * colhgt)
						&& (zCent <= 4 * numstorys * colhgt)) {

					v++;
					double hgtRest = (colhgt + colhgt * v);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (5 + q)
							+ "   JointJ=" + (numstorys + 6 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + width * 3.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > numstorys * colhgt)
						&& (zCent <= 5 * numstorys * colhgt)) {

					t++;
					double hgtRest = (colhgt + colhgt * t);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (6 + q)
							+ "   JointJ=" + (numstorys + 7 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + width * 4.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > numstorys * colhgt)
						&& (zCent <= 6 * numstorys * colhgt)) {

					u++;
					double hgtRest = (colhgt + colhgt * u);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (7 + q)
							+ "   JointJ=" + (numstorys + 8 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + width * 5.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > numstorys * colhgt)
						&& (zCent <= 7 * numstorys * colhgt)) {

					w++;
					double hgtRest = (colhgt + colhgt * w);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (8 + q)
							+ "   JointJ=" + (numstorys + 9 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + width * 6.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > numstorys * colhgt)
						&& (zCent <= 8 * numstorys * colhgt)) {

					y++;
					double hgtRest = (colhgt + colhgt * y);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (9 + q)
							+ "   JointJ=" + (numstorys + 10 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + width * 7.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > numstorys * colhgt)
						&& (zCent <= 9 * numstorys * colhgt)) {

					aa++;
					double hgtRest = (colhgt + colhgt * aa);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (10 + q)
							+ "   JointJ=" + (numstorys + 11 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + width * 8.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > numstorys * colhgt)
						&& (zCent <= 10 * numstorys * colhgt)) {

					bb++;
					double hgtRest = (colhgt + colhgt * bb);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (11 + q)
							+ "   JointJ=" + (numstorys + 12 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX="
							+ (-width1 * bays * 0.5 + width * 9.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				}

			}

			pw.println("TABLE:  \"JOINT RESTRAINT ASSIGNMENTS\"");

			pw.println("   Joint=" + 1
					+ "   U1=Yes   U2=Yes   U3=Yes   R1=Yes   R2=No   R3=Yes");
			pw.println("   Joint=" + (numstorys + 2)
					+ "   U1=Yes   U2=Yes   U3=Yes   R1=Yes   R2=No   R3=Yes");

			int joint1 = 1;

			for (int z = 0; z <= bays - 2; z++) {

				joint1++;
				pw.println("   Joint="
						+ ((joint1 * (numstorys + 1)) + 1)
						+ "   U1=Yes   U2=Yes   U3=Yes   R1=Yes   R2=No   R3=Yes");

			}

			pw.println("");

			pw.println("TABLE:  \"FRAME SECTION ASSIGNMENTS\"");
			pw.println("");

			for (int ff1 = 1; ff1 <= (totFrames + 1); ff1++) {

				if (ff1 <= (numstorys * (bays + 1))) {
					pw.println("   Frame="
							+ ff1
							+ "   SectionType=\"I/Wide Flange\"   AutoSelect=Cols   AnalSect=W14X61   DesignSect=W14X61   MatProp=Default");

				} else if (ff1 > (numstorys * (bays + 1))
						&& (ff1 <= totFrames + 1)) {
					pw.println("   Frame= "
							+ ff1
							+ "   SectionType=\"I/Wide Flange\"   AutoSelect=Beams   AnalSect=W14X61   DesignSect=W14X61   MatProp=Default");
				}
			}

			pw.println("");
			pw.println("");
			pw.println("");
			pw.println("");

			pw.println("TABLE: \"FRAME OUTPUT STATION ASSIGNMENTS\"");

			for (int ll1 = 1; ll1 < (totFrames + 1); ll1++) {

				if (ll1 <= FramesZDir) {

					pw.println("   Frame="
							+ ll1
							+ "   StationType=MinNumSta   MinNumSta=3   AddAtElmInt=Yes   AddAtPtLoad=Yes");

				} else {

					pw.println("   Frame="
							+ ll1
							+ "   StationType=MaxStaSpcg   MaxStaSpcg=2   AddAtElmInt=Yes   AddAtPtLoad=Yes");
				}
			}

			pw.println("TABLE:  \"FRAME AUTO MESH ASSIGNMENTS\"");

			for (int cc = 1; cc <= totFrames; cc++) {

				pw.println("   Frame="
						+ cc
						+ "   AutoMesh=Yes   AtJoints=Yes   AtFrames=No   NumSegments=0   MaxLength=0   MaxDegrees=0");

			}

			pw.println("TABLE:  \"FRAME LOADS - DISTRIBUTED\"");

			for (int dd = (int) (FramesZDir + 1); dd <= (totFrames); dd++) {

				pw.println("Frame="
						+ dd
						+ "   LoadCase=LL   CoordSys=GLOBAL   Type=Force   Dir=Gravity   DistType=RelDist   RelDistA=0   RelDistB=1   AbsDistA=0   AbsDistB=24   FOverLA="
						+ live * loadwidth + "   FOverLB=" + live * loadwidth
						+ "");

				pw.println("   Frame="
						+ dd
						+ "    LoadCase=SDL   CoordSys=GLOBAL   Type=Force   Dir=Gravity   DistType=RelDist   RelDistA=0   RelDistB=1   AbsDistA=0   AbsDistB=24   FOverLA="
						+ sdl * loadwidth + "   FOverLB=" + sdl * loadwidth
						+ "");

			}

			pw.println("");
			pw.println("TABLE:  \"OPTIONS - COLORS - DISPLAY\"");
			pw.println("   DeviceType=Screen   Points=Yellow   LinesFrame=Yellow   LinesFrmExt=Yellow   LinesCable=Green   LinesTendon=Green   SpringLinks=Green   Restraints=Green   Releases=Green   Axes=Cyan   Text=Green   ShadowLines=Gray8Dark _");
			pw.println("        GuideLines=Gray8Dark   Highlight=Red   Selection=White   AreaFillBot=Red   AreaFillTop=16744703   AreaFillSd=Red   AreaEdge=DarkRed   SolidF1=Red   SolidF2=Blue   SolidF3=Green   SolidF4=Yellow   SolidF5=White   SolidF6=Cyan _");
			pw.println("        SolidEdge=DarkRed   Floor=Gray4   Background=Black   BGLowLeft=Black   BGLowRight=Black   BGUpRight=Black   Darkness=0.5");
			pw.println("   DeviceType=Printer   Points=Gray8Dark   LinesFrame=Black   LinesFrmExt=Gray4   LinesCable=Black   LinesTendon=Black   SpringLinks=Gray8Dark   Restraints=Gray8Dark   Releases=Gray4   Axes=Black   Text=Black   ShadowLines=Gray4 _");
			pw.println("        GuideLines=Gray4   Highlight=Black   Selection=Black   AreaFillBot=Gray4   AreaFillTop=Gray8Dark   AreaFillSd=Gray4   AreaEdge=Black   SolidF1=Gray1Light   SolidF2=Gray2   SolidF3=Gray3   SolidF4=Gray4   SolidF5=Gray5 _");
			pw.println("        SolidF6=Gray6   SolidEdge=Black   Floor=Gray4   Background=White   BGLowLeft=White   BGLowRight=White   BGUpRight=White   Darkness=0.5");
			pw.println("   DeviceType=\"Color Printer\"   Points=Black   LinesFrame=7303023   LinesFrmExt=White   LinesCable=Green   LinesTendon=Green   SpringLinks=Green   Restraints=9408399   Releases=Green   Axes=Cyan   Text=Black   ShadowLines=Gray8Dark _");
			pw.println("        GuideLines=10461087   Highlight=Red   Selection=10504778   AreaFillBot=16634568   AreaFillTop=14277119   AreaFillSd=16634568   AreaEdge=7303023   SolidF1=10122991   SolidF2=16756912   SolidF3=11599795   SolidF4=12713983 _");
			pw.println("        SolidF5=White   SolidF6=16777128   SolidEdge=7303023   Floor=10461087   Background=White   BGLowLeft=White   BGLowRight=14671839   BGUpRight=White   Darkness=0.5");
			pw.println("");
			pw.println("TABLE:  \"OPTIONS - COLORS - OUTPUT\"");
			pw.println("   DeviceType=Screen   Contour1=13107400   Contour2=6553828   Contour3=Red   Contour4=16639   Contour5=Orange   Contour6=43775   Contour7=54527   Contour8=Yellow   Contour9=65408   Contour10=Green   Contour11=8453888   Contour12=Cyan _");
			pw.println("        Contour13=16755200   Contour14=16733440   Contour15=Blue   Transpare=0.5   Ratio1=Cyan   Ratio2=Green   Ratio3=Yellow   Ratio4=Orange   Ratio5=Red   RatioNotD=Gray4   RatioNotC=Red   RatioVal1=0.5   RatioVal2=0.7   RatioVal3=0.9 _");
			pw.println("        RatioVal4=1   DFillPos=Yellow   DFillNeg=Red   DFillRPos=Blue   DFillRNeg=Cyan");
			pw.println("   DeviceType=Printer   Contour1=Black   Contour2=3158064   Contour3=4210752   Contour4=5263440   Contour5=6316128   Contour6=7368816   Contour7=Gray8Dark   Contour8=Gray7   Contour9=Gray6   Contour10=Gray5   Contour11=Gray4 _");
			pw.println("        Contour12=Gray3   Contour13=Gray2   Contour14=Gray1Light   Contour15=White   Transpare=0   Ratio1=Gray2   Ratio2=Gray4   Ratio3=Gray8Dark   Ratio4=4210752   Ratio5=Black   RatioNotD=Gray4   RatioNotC=Black   RatioVal1=0.5 _");
			pw.println("        RatioVal2=0.7   RatioVal3=0.9   RatioVal4=1   DFillPos=Gray8Dark   DFillNeg=Gray8Dark   DFillRPos=4210752   DFillRNeg=4210752");
			pw.println("   DeviceType=\"Color Printer\"   Contour1=13107400   Contour2=6553828   Contour3=Red   Contour4=16639   Contour5=Orange   Contour6=43775   Contour7=54527   Contour8=Yellow   Contour9=65408   Contour10=Green   Contour11=8453888 _");
			pw.println("        Contour12=Cyan   Contour13=16755200   Contour14=16733440   Contour15=Blue   Transpare=0.5   Ratio1=Cyan   Ratio2=Green   Ratio3=Yellow   Ratio4=Orange   Ratio5=Red   RatioNotD=Gray4   RatioNotC=Red   RatioVal1=0.5   RatioVal2=0.7 _");
			pw.println("        RatioVal3=0.9   RatioVal4=1   DFillPos=Red   DFillNeg=Red   DFillRPos=Blue   DFillRNeg=Blue");
			pw.println("");
			pw.println("TABLE:  \"PREFERENCES - DIMENSIONAL\"");
			pw.println("MergeTol=8.33333333333333E-03   FineGrid=1   Nudge=1   SelectTol=3   SnapTol=12   SLineThick=1   PLineThick=4   MaxFont=8   MinFont=3   AutoZoom=10   ShrinkFact=70   TextFileLen=240");
			pw.println("");
			pw.println("TABLE:  \"PREFERENCES - STEEL DESIGN - AISC360-05-IBC2006\"");
			pw.println("   THDesign=Envelopes   FrameType=SMF   PatLLF=0.75   SRatioLimit=0.95   MaxIter=1   SDC=D   SeisCode=Yes   SeisLoad=Yes   ImpFactor=1   SystemRho=1   SystemSds=0.5   SystemR=8   SystemCd=5.5   Omega0=3   Provision=LRFD _");
			pw.println("        AMethod=\"Direct Analysis\"   SOMethod=\"General 2nd Order\"   SRMethod=\"Tau-b Fixed\"   NLCoeff=0.002   PhiB=0.9   PhiC=0.9   PhiTY=0.9   PhiTF=0.75   PhiV=0.9   PhiVRolledI=1   PhiVT=0.9   PlugWeld=Yes   HSSWelding=ERW   HSSReduceT=No _");
			pw.println("        CheckDefl=Yes   DLRat=120   SDLAndLLRat=120   LLRat=360   TotalRat=240   NetRat=240");
			pw.println("");
			pw.println("TABLE:  \"PROGRAM CONTROL\"");
			pw.println("ProgramName=SAP2000   Version=11.0.8   CurrUnits=\"Kip, ft, F\"   SteelCode=AISC-LRFD93   ConcCode=\"ACI 318-05/IBC2003\"   AlumCode=\"AA-ASD 2000\"   ColdCode=AISI-ASD96   RegenHinge=Yes");
			pw.println("");
			pw.println("TABLE:  \"PROJECT INFORMATION\"");
			pw.println("   Item=\"Company Name\"");
			pw.println("   Item=\"Client Name\"");
			pw.println("   Item=\"Project Name\"");
			pw.println("   Item=\"Project Number\"");
			pw.println("   Item=\"Model Name\"");
			pw.println("   Item=\"Model Description\"");
			pw.println("   Item=\"Revision Number\"");
			pw.println("   Item=\"Frame Type\"");
			pw.println("   Item=Engineer");
			pw.println("   Item=Checker");
			pw.println("   Item=Supervisor");
			pw.println("   Item=\"Issue Code\"");
			pw.println("   Item=\"Design Code\"");
			pw.println("");
			pw.println("END TABLE DATA");
			pw.println("");

			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
}
