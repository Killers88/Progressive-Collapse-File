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

	public static String sapFile(final double storys, final double bays,
			final double colhgt, final double width1, final double live,
			final double sdl, final double loadwidth) {

		double width = width1 / bays;

		try {
			String filePath = "///Users/koleary/Desktop/SAP_Import_File.txt";

			PrintWriter pw = new PrintWriter(filePath);

			pw.println("TABLE:  \"PROGRAM CONTROL\"");
			pw.println("ProgramName=SAP2000   Version=11.0.8   ProgLevel=Advanced   LicenseOS=No   LicenseSC=No   LicenseBR=No   LicenseHT=No   CurrUnits=\"Kip, ft, F\"   SteelCode=AISC-LRFD93   ConcCode=\"ACI 318-05/IBC2003\"   AlumCode=\"AA-ASD 2000\" _");
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

			for (int i = 0; i < (storys + 1); i++) {

				pw.println("CoordSys=GLOBAL   AxisDir=X   GridID=x"
						+ (i + 1)
						+ "   XRYZCoord= "
						+ ((i * width1) + -120)
						+ ",   LineType=Primary   LineColor=Gray8Dark   Visible=Yes   BubbleLoc=End");
			}

			pw.println("CoordSys=GLOBAL   AxisDir=Y   GridID=y1   XRYZCoord=0   LineType=Primary   LineColor=Gray8Dark   Visible=Yes   BubbleLoc=Start");

			for (int i = 0; i < (bays + 1); i++) {

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
			pw.println("   LoadCase=LR   DesignType=LIVE   SelfWtMult=0");
			pw.println("   LoadCase=LL   DesignType=LIVE   SelfWtMult=0");
			pw.println("   LoadCase=SDL_FL   DesignType=DEAD   SelfWtMult=0");
			pw.println("   LoadCase=SDL_R   DesignType=DEAD   SelfWtMult=0");
			pw.println("   LoadCase=COL_EQUIV   DesignType=OTHER   SelfWtMult=0");
			pw.println("   LoadCase=COL_CANCEL   DesignType=OTHER   SelfWtMult=0");
			pw.println("");
			pw.println("TABLE:  \"AUTO WAVE 3 - WAVE CHARACTERISTICS - GENERAL\"");
			pw.println("   WaveChar=Default   WaveType=\"From Theory\"   KinFactor=1   SWaterDepth=1800   WaveHeight=720   WavePeriod=12   WaveTheory=Linear");

			/*
			 * COMBINATIONS
			 */
			pw.println("TABLE:  \"COMBINATION DEFINITIONS\"");
			pw.println(" ComboName=UDSTL1   ComboType=\"Linear Add\"   AutoDesign=No   CaseType=\"Linear Static\"   CaseName=DEAD   ScaleFactor=1.4   SteelDesign=Yes   ConcDesign=No   AlumDesign=No   ColdDesign=No");
			pw.println("   ComboName=UDSTL1   CaseType=\"Linear Static\"   CaseName=SDL_FL   ScaleFactor=1.4");
			pw.println("   ComboName=UDSTL1   CaseType=\"Linear Static\"   CaseName=SDL_R   ScaleFactor=1.4");
			pw.println("ComboName=UDSTL2   ComboType=\"Linear Add\"   AutoDesign=No   CaseType=\"Linear Static\"   CaseName=DEAD   ScaleFactor=1.2   SteelDesign=Yes   ConcDesign=No   AlumDesign=No   ColdDesign=No");
			pw.println("   ComboName=UDSTL2   CaseType=\"Linear Static\"   CaseName=LL   ScaleFactor=1.6");
			pw.println("   ComboName=UDSTL2   CaseType=\"Linear Static\"   CaseName=LR   ScaleFactor=1.6");
			pw.println("   ComboName=UDSTL2   CaseType=\"Linear Static\"   CaseName=SDL_FL   ScaleFactor=1.2");
			pw.println("   ComboName=UDSTL2   CaseType=\"Linear Static\"   CaseName=SDL_R   ScaleFactor=1.2");
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
			pw.println("   Case=LR   Type=LinStatic   InitialCond=Zero   RunCase=Yes");
			pw.println("   Case=SDL_FL   Type=LinStatic   InitialCond=Zero   RunCase=Yes");
			pw.println("   Case=SDL_R   Type=LinStatic   InitialCond=Zero   RunCase=Yes");
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
			pw.println("   Case=LR   LoadType=\"Load case\"   LoadName=LR   LoadSF=1");
			pw.println("   Case=SDL_FL   LoadType=\"Load case\"   LoadName=SDL_FL   LoadSF=1");
			pw.println("   Case=SDL_R   LoadType=\"Load case\"   LoadName=SDL_R   LoadSF=1");
			pw.println("   Case=COL_EQUIV   LoadType=\"Load case\"   LoadName=COL_EQUIV   LoadSF=1");
			pw.println("   Case=COL_CANCEL   LoadType=\"Load case\"   LoadName=COL_CANCEL   LoadSF=1");
			pw.println("   Case=NLS_PC   LoadType=\"Load case\"   LoadName=DEAD   LoadSF=1.2");
			pw.println("   Case=NLS_PC   LoadType=\"Load case\"   LoadName=SDL_FL   LoadSF=1.2");
			pw.println("   Case=NLS_PC   LoadType=\"Load case\"   LoadName=SDL_R   LoadSF=1.2");
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

			double x = storys;

			int joint = 0;

			for (int i = 0; i <= (nodesX - 1); i++) {

				for (int j = 0; j <= x; j++) {

					joint++;

					pw.println("Joint="
							+ (joint)
							+ "   CoordSys=GLOBAL   CoordType=Cartesian   XorR="
							+ (-120 + (i * width)) + "   Y=0   Z="
							+ (j * colhgt) + "   SpecialJt=No   GlobalX="
							+ (-120 + (i * width)) + "   GlobalY=0   GlobalZ="
							+ (j * colhgt) + "");
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

			for (int l = 1; l <= (storys * (bays + 1)); l++) {

				if (l <= storys) {
					a++;
					pw.println("   Frame=" + (l) + "   JointI=" + l
							+ "   JointJ=" + (l + 1)
							+ "   IsCurved=No   Length=" + colhgt
							+ "   CentroidX=" + (-120)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (a - 1))) + "");
				} else if ((l > storys) && (l <= (2 * storys))) {
					b++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 1)
							+ "   JointJ=" + (l + 2)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX=" + (-120 + width)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (b - 1))) + "");

				} else if (l <= (3 * storys)) {
					c++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 2)
							+ "   JointJ=" + (l + 3)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX=" + (-120 + 2 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (c - 1))) + "");
				} else if (l <= (4 * storys)) {
					d++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 3)
							+ "   JointJ=" + (l + 4)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX=" + (-120 + 3 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (d - 1))) + "");
				} else if (l <= (5 * storys)) {
					e++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 4)
							+ "   JointJ=" + (l + 5)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX=" + (-120 + 4 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (e - 1))) + "");
				} else if (l <= (6 * storys)) {
					f++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 5)
							+ "   JointJ=" + (l + 6)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX=" + (-120 + 5 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (f - 1))) + "");
				} else if (l <= (7 * storys)) {
					g++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 6)
							+ "   JointJ=" + (l + 7)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX=" + (-120 + 6 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (g - 1))) + "");

				} else if (l <= (8 * storys)) {
					h++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 7)
							+ "   JointJ=" + (l + 8)
							+ "   IsCurved=No   Length=" + colhgt
							+ "   CentroidX=" + (-120 + 7 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (h - 1))) + "");
				} else if (l <= (9 * storys)) {
					i++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 8)
							+ "   JointJ=" + (l + 9)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX=" + (-120 + 8 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (i - 1))) + "");
				} else if (l <= (10 * storys)) {
					j++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 9)
							+ "   JointJ=" + (l + 10)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX=" + (-120 + 9 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (j - 1))) + "");
				} else if (l <= (11 * storys)) {
					k++;
					pw.println("   Frame=" + (l) + "   JointI=" + (l + 10)
							+ "   JointJ=" + (l + 11)
							+ "   IsCurved=No   Length="

							+ colhgt + "   CentroidX=" + (-120 + 10 * width)
							+ "    CentroidY=0   CentroidZ="
							+ (6 + (colhgt * (k - 1))) + "");
				}
			}

			double FramesZDir = storys * (bays + 1);
			double totFrames = (storys * (bays + 1) + storys * bays);

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

			for (double s = (FramesZDir + 2); s <= totFrames; s++) {

				q++;
				double zCent = (colhgt + colhgt * q);

				if (zCent <= storys * colhgt) {
					pw.println("   Frame=" + (s - 1) + "   JointI=" + (2 + q)
							+ "   JointJ=" + (storys + 3 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX=" + (-120 + width * 0.5)
							+ "    CentroidY=0   CentroidZ=" + zCent + "");
				} else if ((zCent > storys * colhgt)
						&& (zCent <= 2 * storys * colhgt)) {

					r++;
					double hgtRest = (colhgt + colhgt * r);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (3 + q)
							+ "   JointJ=" + (storys + 4 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX=" + (-120 + width * 1.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > storys * colhgt)
						&& (zCent <= 3 * storys * colhgt)) {

					p++;
					double hgtRest = (colhgt + colhgt * p);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (4 + q)
							+ "   JointJ=" + (storys + 5 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX=" + (-120 + width * 2.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > storys * colhgt)
						&& (zCent <= 4 * storys * colhgt)) {

					v++;
					double hgtRest = (colhgt + colhgt * v);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (5 + q)
							+ "   JointJ=" + (storys + 6 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX=" + (-120 + width * 3.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > storys * colhgt)
						&& (zCent <= 5 * storys * colhgt)) {

					t++;
					double hgtRest = (colhgt + colhgt * t);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (6 + q)
							+ "   JointJ=" + (storys + 7 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX=" + (-120 + width * 4.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > storys * colhgt)
						&& (zCent <= 6 * storys * colhgt)) {

					u++;
					double hgtRest = (colhgt + colhgt * u);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (7 + q)
							+ "   JointJ=" + (storys + 8 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX=" + (-120 + width * 5.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > storys * colhgt)
						&& (zCent <= 7 * storys * colhgt)) {

					w++;
					double hgtRest = (colhgt + colhgt * w);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (8 + q)
							+ "   JointJ=" + (storys + 9 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX=" + (-120 + width * 6.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > storys * colhgt)
						&& (zCent <= 8 * storys * colhgt)) {

					y++;
					double hgtRest = (colhgt + colhgt * y);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (9 + q)
							+ "   JointJ=" + (storys + 10 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX=" + (-120 + width * 7.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > storys * colhgt)
						&& (zCent <= 9 * storys * colhgt)) {

					aa++;
					double hgtRest = (colhgt + colhgt * aa);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (10 + q)
							+ "   JointJ=" + (storys + 11 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX=" + (-120 + width * 8.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				} else if ((zCent > storys * colhgt)
						&& (zCent <= 10 * storys * colhgt)) {

					bb++;
					double hgtRest = (colhgt + colhgt * bb);

					pw.println("   Frame=" + (s - 1) + "   JointI=" + (11 + q)
							+ "   JointJ=" + (storys + 12 + q)
							+ "   IsCurved=No   Length=" + width
							+ "   CentroidX=" + (-120 + width * 9.5)
							+ "    CentroidY=0   CentroidZ=" + hgtRest + "");
				}

			}

			pw.println("TABLE:  \"JOINT RESTRAINT ASSIGNMENTS\"");

			pw.println("   Joint=" + 1
					+ "   U1=Yes   U2=Yes   U3=Yes   R1=Yes   R2=No   R3=Yes");
			pw.println("   Joint=" + (storys + 2)
					+ "   U1=Yes   U2=Yes   U3=Yes   R1=Yes   R2=No   R3=Yes");

			int joint1 = 1;

			for (int z = 0; z <= bays - 2; z++) {

				joint1++;
				pw.println("   Joint="
						+ ((joint1 * (storys + 1)) + 1)
						+ "   U1=Yes   U2=Yes   U3=Yes   R1=Yes   R2=No   R3=Yes");

			}

			pw.println("TABLE: \"FRAME OUTPUT STATION ASSIGNMENTS\"");

			for (int ll1 = 1; ll1 < totFrames; ll1++) {

				if (ll1 <= FramesZDir) {

					pw.println("   Frame="
							+ ll1
							+ "   StationType=MinNumSta   MinNumSta=3   AddAtElmInt=Yes   AddAtPtLoad=Yes");

				} else {

					pw.println("   Frame="
							+ ll1
							+ "   StationType=MinNumSta   MinNumSta=2   AddAtElmInt=Yes   AddAtPtLoad=Yes");
				}
			}

			pw.println("TABLE:  \"FRAME AUTO MESH ASSIGNMENTS\"");

			for (int cc = 1; cc <= totFrames; cc++) {

				pw.println("   Frame="
						+ cc
						+ "   AutoMesh=Yes   AtJoints=Yes   AtFrames=No   NumSegments=0   MaxLength=0   MaxDegrees=0");

			}

			pw.println("TABLE:  \"FRAME LOADS - DISTRIBUTED\"");

			for (double dd = (FramesZDir + 1); dd <= (totFrames); dd++) {

				pw.println("Frame="
						+ dd
						+ "   LoadCase=LL   CoordSys=GLOBAL   Type=Force   Dir=Gravity   DistType=RelDist   RelDistA=0   RelDistB=1   AbsDistA=0   AbsDistB=24   FOverLA="
						+ live * loadwidth + "   FOverLB=" + live * loadwidth
						+ "");

				pw.println("   Frame="
						+ dd
						+ "    LoadCase=SDL_FL   CoordSys=GLOBAL   Type=Force   Dir=Gravity   DistType=RelDist   RelDistA=0   RelDistB=1   AbsDistA=0   AbsDistB=24   FOverLA="
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
			pw.println("TABLE:  \"PREFERENCES - STEEL DESIGN - AISC-LRFD93\"");
			pw.println("THDesign=Envelopes   FrameType=\"Moment Frame\"   PatLLF=0.75   SRatioLimit=0.95   MaxIter=1   PhiB=0.9   PhiC=0.85   PhiT=0.9   PhiV=0.9   PhiCA=0.9   CheckDefl=No   DLRat=120   SDLAndLLRat=120   LLRat=360   TotalRat=240   NetRat=240");
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
