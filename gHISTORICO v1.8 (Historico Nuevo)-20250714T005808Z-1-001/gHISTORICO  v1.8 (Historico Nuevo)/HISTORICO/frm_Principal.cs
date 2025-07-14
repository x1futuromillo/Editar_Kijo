using System;
using System.ComponentModel;
using System.Diagnostics;
using System.Drawing;
using System.IO;
using System.Runtime.CompilerServices;
using System.Text;
using System.Windows.Forms;
using Microsoft.VisualBasic;
using Microsoft.VisualBasic.CompilerServices;

namespace HISTORICO;

public class frm_Principal : Form
{
	[AccessedThroughProperty("Label1")]
	private Label _Label1;

	[AccessedThroughProperty("lbl_Informacion")]
	private Label _lbl_Informacion;

	[AccessedThroughProperty("SelecciónHistorico")]
	private GroupBox _SelecciónHistorico;

	[AccessedThroughProperty("MainMenu1")]
	private MainMenu _MainMenu1;

	[AccessedThroughProperty("txt_Historico")]
	private TextBox _txt_Historico;

	[AccessedThroughProperty("cmd_Aceptar")]
	private Button _cmd_Aceptar;

	[AccessedThroughProperty("Rd_HistoricoNormal")]
	private RadioButton _Rd_HistoricoNormal;

	[AccessedThroughProperty("Rd_historicoNuevo")]
	private RadioButton _Rd_historicoNuevo;

	private const string DirectorioHistoricos = "C:/Historicos";

	private IContainer components;

	internal virtual MainMenu MainMenu1
	{
		get
		{
			return _MainMenu1;
		}
		[MethodImpl(MethodImplOptions.Synchronized)]
		set
		{
			if (_MainMenu1 != null)
			{
			}
			_MainMenu1 = value;
			if (_MainMenu1 == null)
			{
			}
		}
	}

	internal virtual TextBox txt_Historico
	{
		get
		{
			return _txt_Historico;
		}
		[MethodImpl(MethodImplOptions.Synchronized)]
		set
		{
			if (_txt_Historico != null)
			{
			}
			_txt_Historico = value;
			if (_txt_Historico == null)
			{
			}
		}
	}

	internal virtual Label lbl_Informacion
	{
		get
		{
			return _lbl_Informacion;
		}
		[MethodImpl(MethodImplOptions.Synchronized)]
		set
		{
			if (_lbl_Informacion != null)
			{
			}
			_lbl_Informacion = value;
			if (_lbl_Informacion == null)
			{
			}
		}
	}

	internal virtual GroupBox SelecciónHistorico
	{
		get
		{
			return _SelecciónHistorico;
		}
		[MethodImpl(MethodImplOptions.Synchronized)]
		set
		{
			if (_SelecciónHistorico != null)
			{
			}
			_SelecciónHistorico = value;
			if (_SelecciónHistorico == null)
			{
			}
		}
	}

	internal virtual Button cmd_Aceptar
	{
		get
		{
			return _cmd_Aceptar;
		}
		[MethodImpl(MethodImplOptions.Synchronized)]
		set
		{
			if (_cmd_Aceptar != null)
			{
				((Control)_cmd_Aceptar).Click -= cmd_Aceptar_Click;
			}
			_cmd_Aceptar = value;
			if (_cmd_Aceptar != null)
			{
				((Control)_cmd_Aceptar).Click += cmd_Aceptar_Click;
			}
		}
	}

	internal virtual RadioButton Rd_HistoricoNormal
	{
		get
		{
			return _Rd_HistoricoNormal;
		}
		[MethodImpl(MethodImplOptions.Synchronized)]
		set
		{
			if (_Rd_HistoricoNormal != null)
			{
			}
			_Rd_HistoricoNormal = value;
			if (_Rd_HistoricoNormal == null)
			{
			}
		}
	}

	internal virtual RadioButton Rd_historicoNuevo
	{
		get
		{
			return _Rd_historicoNuevo;
		}
		[MethodImpl(MethodImplOptions.Synchronized)]
		set
		{
			if (_Rd_historicoNuevo != null)
			{
			}
			_Rd_historicoNuevo = value;
			if (_Rd_historicoNuevo == null)
			{
			}
		}
	}

	internal virtual Label Label1
	{
		get
		{
			return _Label1;
		}
		[MethodImpl(MethodImplOptions.Synchronized)]
		set
		{
			if (_Label1 != null)
			{
			}
			_Label1 = value;
			if (_Label1 == null)
			{
			}
		}
	}

	[STAThread]
	public static void Main()
	{
		Application.Run((Form)(object)new frm_Principal());
	}

	public frm_Principal()
	{
		((Form)this).Load += frm_Principal_Load;
		InitializeComponent();
	}

	protected override void Dispose(bool disposing)
	{
		if (disposing && components != null)
		{
			components.Dispose();
		}
		((Form)this).Dispose(disposing);
	}

	[DebuggerStepThrough]
	private void InitializeComponent()
	{
		//IL_0002: Unknown result type (might be due to invalid IL or missing references)
		//IL_000c: Expected O, but got Unknown
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		//IL_001a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0024: Expected O, but got Unknown
		//IL_0026: Unknown result type (might be due to invalid IL or missing references)
		//IL_0030: Expected O, but got Unknown
		//IL_0032: Unknown result type (might be due to invalid IL or missing references)
		//IL_003c: Expected O, but got Unknown
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0048: Expected O, but got Unknown
		//IL_004a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0054: Expected O, but got Unknown
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected O, but got Unknown
		//IL_0107: Unknown result type (might be due to invalid IL or missing references)
		//IL_0111: Expected O, but got Unknown
		//IL_01cd: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d7: Expected O, but got Unknown
		MainMenu1 = new MainMenu();
		txt_Historico = new TextBox();
		lbl_Informacion = new Label();
		SelecciónHistorico = new GroupBox();
		Rd_historicoNuevo = new RadioButton();
		Rd_HistoricoNormal = new RadioButton();
		cmd_Aceptar = new Button();
		Label1 = new Label();
		((Control)SelecciónHistorico).SuspendLayout();
		((Control)this).SuspendLayout();
		TextBox obj = txt_Historico;
		Point location = new Point(0, 0);
		((Control)obj).Location = location;
		((TextBoxBase)txt_Historico).Multiline = true;
		((Control)txt_Historico).Name = "txt_Historico";
		TextBox obj2 = txt_Historico;
		Size size = new Size(584, 240);
		((Control)obj2).Size = size;
		((Control)txt_Historico).TabIndex = 68;
		txt_Historico.Text = "";
		lbl_Informacion.BorderStyle = (BorderStyle)1;
		((Control)lbl_Informacion).Font = new Font("Microsoft Sans Serif", 12f, (FontStyle)1, (GraphicsUnit)3, (byte)0);
		Label obj3 = lbl_Informacion;
		location = new Point(8, 8);
		((Control)obj3).Location = location;
		((Control)lbl_Informacion).Name = "lbl_Informacion";
		Label obj4 = lbl_Informacion;
		size = new Size(528, 40);
		((Control)obj4).Size = size;
		((Control)lbl_Informacion).TabIndex = 69;
		((Control)SelecciónHistorico).BackColor = SystemColors.Control;
		((Control)SelecciónHistorico).Controls.Add((Control)(object)Rd_historicoNuevo);
		((Control)SelecciónHistorico).Controls.Add((Control)(object)Rd_HistoricoNormal);
		((Control)SelecciónHistorico).Controls.Add((Control)(object)cmd_Aceptar);
		((Control)SelecciónHistorico).Font = new Font("Microsoft Sans Serif", 9.75f, (FontStyle)1, (GraphicsUnit)3, (byte)0);
		GroupBox selecciónHistorico = SelecciónHistorico;
		location = new Point(48, 88);
		((Control)selecciónHistorico).Location = location;
		((Control)SelecciónHistorico).Name = "SelecciónHistorico";
		GroupBox selecciónHistorico2 = SelecciónHistorico;
		size = new Size(408, 80);
		((Control)selecciónHistorico2).Size = size;
		((Control)SelecciónHistorico).TabIndex = 70;
		SelecciónHistorico.TabStop = false;
		SelecciónHistorico.Text = "Tipo histórico";
		RadioButton rd_historicoNuevo = Rd_historicoNuevo;
		location = new Point(16, 48);
		((Control)rd_historicoNuevo).Location = location;
		((Control)Rd_historicoNuevo).Name = "Rd_historicoNuevo";
		RadioButton rd_historicoNuevo2 = Rd_historicoNuevo;
		size = new Size(272, 24);
		((Control)rd_historicoNuevo2).Size = size;
		((Control)Rd_historicoNuevo).TabIndex = 2;
		((Control)Rd_historicoNuevo).Text = "Histórico Nuevo";
		RadioButton rd_HistoricoNormal = Rd_HistoricoNormal;
		location = new Point(16, 24);
		((Control)rd_HistoricoNormal).Location = location;
		((Control)Rd_HistoricoNormal).Name = "Rd_HistoricoNormal";
		RadioButton rd_HistoricoNormal2 = Rd_HistoricoNormal;
		size = new Size(136, 16);
		((Control)rd_HistoricoNormal2).Size = size;
		((Control)Rd_HistoricoNormal).TabIndex = 1;
		((Control)Rd_HistoricoNormal).Text = "Historico Antiguo";
		Button obj5 = cmd_Aceptar;
		location = new Point(320, 32);
		((Control)obj5).Location = location;
		((Control)cmd_Aceptar).Name = "cmd_Aceptar";
		Button obj6 = cmd_Aceptar;
		size = new Size(80, 32);
		((Control)obj6).Size = size;
		((Control)cmd_Aceptar).TabIndex = 0;
		((Control)cmd_Aceptar).Text = "ACEPTAR";
		Label label = Label1;
		location = new Point(48, 176);
		((Control)label).Location = location;
		((Control)Label1).Name = "Label1";
		Label label2 = Label1;
		size = new Size(376, 24);
		((Control)label2).Size = size;
		((Control)Label1).TabIndex = 71;
		((Control)Label1).Text = "NOTA: Este programa comprueba que tenemos el número de bytes correcto en cada trama";
		size = new Size(5, 13);
		((Form)this).AutoScaleBaseSize = size;
		((Form)this).BackColor = Color.White;
		size = new Size(570, 208);
		((Form)this).ClientSize = size;
		((Control)this).Controls.Add((Control)(object)Label1);
		((Control)this).Controls.Add((Control)(object)SelecciónHistorico);
		((Control)this).Controls.Add((Control)(object)lbl_Informacion);
		((Control)this).Controls.Add((Control)(object)txt_Historico);
		((Form)this).FormBorderStyle = (FormBorderStyle)5;
		((Form)this).Menu = MainMenu1;
		((Control)this).Name = "frm_Principal";
		((Control)SelecciónHistorico).ResumeLayout(false);
		((Control)this).ResumeLayout(false);
	}

	private void frm_Principal_Load(object sender, EventArgs e)
	{
		((Control)this).Text = "HISTORICO                                     TECNOLOGÍA GPS S.A.       v1.8";
		((Control)lbl_Informacion).Text = "Indique tipo de HISTORICO, pulse Aceptar y seleccione fichero con la información de histórico en formato hexadecimal.";
		Rd_historicoNuevo.Checked = true;
	}

	private void cmd_Aceptar_Click(object sender, EventArgs e)
	{
		//IL_046a: Unknown result type (might be due to invalid IL or missing references)
		//IL_043d: Unknown result type (might be due to invalid IL or missing references)
		//IL_03e4: Unknown result type (might be due to invalid IL or missing references)
		//IL_037f: Unknown result type (might be due to invalid IL or missing references)
		//IL_02ac: Unknown result type (might be due to invalid IL or missing references)
		//IL_0289: Unknown result type (might be due to invalid IL or missing references)
		checked
		{
			try
			{
				int num = 0;
				bool flag = false;
				bool flag2 = true;
				string text = "";
				text = ObtenerRutaArchivoHistorico();
				if (StringType.StrCmp(text, "", false) == 0)
				{
					return;
				}
				StreamReader streamReader = new StreamReader(text);
				string text2 = streamReader.ReadToEnd();
				streamReader.Close();
				long num2 = Strings.Len(text2);
				for (long num3 = 1L; num3 <= num2; num3++)
				{
					if (StringType.StrCmp(Strings.Mid(text2, (int)num3, 3), "***", false) != 0)
					{
						continue;
					}
					num3 += 3L;
					string text3 = Strings.Mid(text2, (int)num3, 5);
					num3 += 5L;
					long num4 = num3;
					long num5 = Strings.Len(text2);
					for (long num6 = num4; num6 <= num5; num6++)
					{
						if (StringType.StrCmp(Strings.Mid(text2, (int)num6, 3), "***", false) == 0)
						{
							num = (int)LongType.FromString(Strings.Mid(text2, (int)num3, (int)(num6 - num3)));
							text2 = Strings.Right(text2, (int)(Strings.Len(text2) - (num6 + 2L)));
							break;
						}
					}
					break;
				}
				if (num != 0)
				{
					long num7 = num;
					string text4 = default(string);
					string text5 = default(string);
					for (long num8 = 1L; num8 <= num7; num8++)
					{
						long num9 = Strings.Len(text2);
						for (long num3 = 1L; num3 <= num9; num3++)
						{
							if (StringType.StrCmp(Strings.Mid(text2, (int)num3, 1), "#", false) != 0)
							{
								continue;
							}
							num3++;
							long num10 = num3;
							long num11 = Strings.Len(text2);
							for (long num6 = num10; num6 <= num11; num6++)
							{
								if (StringType.StrCmp(Strings.Mid(text2, (int)num6, 1), "#", false) != 0)
								{
									continue;
								}
								text4 = StringType.FromLong(LongType.FromString(Strings.Mid(text2, (int)num3, (int)(num6 - num3))));
								text2 = Strings.Right(text2, (int)(Strings.Len(text2) - num6));
								long num12 = Strings.Len(text2);
								for (long num13 = 1L; num13 <= num12; num13++)
								{
									if (!((StringType.StrCmp(Strings.Mid(text2, (int)num13, 1), "#", false) == 0) | (StringType.StrCmp(Strings.Mid(text2, (int)num13, 6), "******", false) == 0)))
									{
										continue;
									}
									text5 = Strings.Left(text2, (int)(num13 - 1L));
									if (Rd_HistoricoNormal.Checked)
									{
										if (Strings.Len(text5) != 332)
										{
											Interaction.MsgBox((object)"TRAMA DE NO 166 BYTES", (MsgBoxStyle)16, (object)"HISTORICO");
										}
									}
									else if (Strings.Len(text5) != 348)
									{
										Interaction.MsgBox((object)"TRAMA DE NO 174 BYTES", (MsgBoxStyle)16, (object)"HISTORICO");
									}
									text2 = Strings.Right(text2, (int)(Strings.Len(text2) - (num13 - 1L)));
									if (StringType.StrCmp(Strings.Mid(text2, 1, 6), "******", false) == 0)
									{
										flag = true;
									}
									break;
								}
								break;
							}
							break;
						}
						if (Rd_HistoricoNormal.Checked)
						{
							if (flag)
							{
								if (num == 1)
								{
									GuardarArchivoTexto("Fecha, Hora, Nº Satélites, Edad, Latitud, Longitud, Velocidad, Distancia, Alarma, Ignición, Movimiento, Numero trama");
									flag2 = false;
								}
								TratarTramaNormal(text5, IntegerType.FromString(text4));
								Interaction.MsgBox((object)"Archivo historico OK creado en C:\\Historicos", (MsgBoxStyle)0, (object)"HISTORICO");
								break;
							}
							if (flag2)
							{
								GuardarArchivoTexto("Fecha, Hora, Nº Satélites, Edad, Latitud, Longitud, Velocidad, Distancia, Alarma, Ignición, Movimiento, Numero trama");
								flag2 = false;
							}
							TratarTramaNormal(text5, IntegerType.FromString(text4));
							continue;
						}
						if (flag)
						{
							if (num == 1)
							{
								GuardarArchivoTexto("Fecha, Hora, Rumbo, Edad, Latitud, Longitud, Velocidad, Distancia (dam), Alarma, Movimiento, Numero trama");
								flag2 = false;
							}
							TratarHistoricoNuevo(text5, IntegerType.FromString(text4));
							Interaction.MsgBox((object)"Archivo historico OK creado en C:\\Historicos", (MsgBoxStyle)0, (object)"HISTORICO");
							break;
						}
						if (flag2)
						{
							GuardarArchivoTexto("Fecha, Hora, Rumbo, Edad, Latitud, Longitud, Velocidad, Distancia (dam), Alarma, Movimiento, Numero trama");
							flag2 = false;
						}
						TratarHistoricoNuevo(text5, IntegerType.FromString(text4));
					}
				}
				else
				{
					Interaction.MsgBox((object)"Formato de trama incorrecto", (MsgBoxStyle)16, (object)"HISTORICO");
				}
			}
			catch (Exception ex)
			{
				ProjectData.SetProjectError(ex);
				Exception ex2 = ex;
				Interaction.MsgBox((object)("Error Aplicación Nº 1. " + ex2.ToString()), (MsgBoxStyle)16, (object)"HISTORICO");
				ProjectData.ClearProjectError();
			}
		}
	}

	private string ObtenerRutaArchivoHistorico()
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		//IL_008c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		OpenFileDialog val = new OpenFileDialog();
		string fileName = default(string);
		try
		{
			if (!Directory.Exists("C:/Historicos"))
			{
				Directory.CreateDirectory("C:/Historicos");
			}
			((FileDialog)val).Filter = "Archivos de Texto (*.txt)|*.txt|Todos los archivos (*.*)|*.*";
			val.Multiselect = false;
			val.CheckFileExists = false;
			((FileDialog)val).Title = "Selección de fichero";
			((CommonDialog)val).ShowDialog();
			if (StringType.StrCmp(((FileDialog)val).FileName, "", false) != 0)
			{
				fileName = ((FileDialog)val).FileName;
				return fileName;
			}
		}
		catch (Exception ex)
		{
			ProjectData.SetProjectError(ex);
			Exception ex2 = ex;
			Interaction.MsgBox((object)("Error Aplicación Nº 7. " + ex2.ToString()), (MsgBoxStyle)16, (object)"HISTORICO");
			ProjectData.ClearProjectError();
		}
		return fileName;
	}

	private void TratarTramaNormal(string CadenaTrama, int NumeroTrama)
	{
		//IL_0ad9: Unknown result type (might be due to invalid IL or missing references)
		checked
		{
			try
			{
				string text = StringType.FromInteger(1);
				string text2 = ConversionHexToBin(CadenaTrama);
				string binVal = Strings.Mid(text2, IntegerType.FromString(text), 8);
				long num = ConvertHexaToDecimal(binVal);
				int num2 = (int)num;
				text = StringType.FromDouble(DoubleType.FromString(text) + 8.0);
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 6);
				long num3 = ConvertHexaToDecimal(binVal);
				string text3 = StringType.FromDouble(DoubleType.FromString(StringType.FromLong(num3)) + 1980.0);
				text = StringType.FromDouble(DoubleType.FromString(text) + 6.0);
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 25);
				long num4 = ConvertHexaToDecimal(binVal);
				long numeroSegundosAno = num4;
				object obj = default(object);
				string Mes = StringType.FromObject(obj);
				object obj2 = default(object);
				string Dia = StringType.FromObject(obj2);
				object obj3 = default(object);
				string Hora = StringType.FromObject(obj3);
				object obj4 = default(object);
				string Minuto = StringType.FromObject(obj4);
				object obj5 = default(object);
				string Segundo = StringType.FromObject(obj5);
				ObtenerFecha(numeroSegundosAno, ref Mes, ref Dia, ref Hora, ref Minuto, ref Segundo);
				obj5 = Segundo;
				obj4 = Minuto;
				obj3 = Hora;
				obj2 = Dia;
				obj = Mes;
				text = StringType.FromDouble(DoubleType.FromString(text) + 25.0);
				string text4 = StringType.FromObject(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj((object)text4, obj2), (object)"/"), obj), (object)"/"), (object)text3), (object)", "), obj3), (object)":"), obj4), (object)":"), obj5), (object)", "));
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 4);
				num = ConvertHexaToDecimal(binVal);
				string text5 = StringType.FromLong(num);
				text = StringType.FromDouble(DoubleType.FromString(text) + 4.0);
				text4 = text4 + text5 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 1);
				char c = CharType.FromString(binVal);
				text = StringType.FromDouble(DoubleType.FromString(text) + 1.0);
				text4 = text4 + StringType.FromChar(c) + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 32);
				long num5 = ((StringType.StrCmp(Strings.Mid(binVal, 1, 1), "0", false) != 0) ? (-2147483648L) : 0L);
				binVal = Strings.Right(binVal, Strings.Len(binVal) - 1);
				long num6 = ConvertHexaToDecimal(binVal);
				num5 += num6;
				num6 = num5;
				string text6 = StringType.FromLong(num5);
				text = StringType.FromDouble(DoubleType.FromString(text) + 32.0);
				text4 = text4 + text6 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 32);
				num5 = ((StringType.StrCmp(Strings.Mid(binVal, 1, 1), "0", false) != 0) ? (-2147483648L) : 0L);
				binVal = Strings.Right(binVal, Strings.Len(binVal) - 1);
				long num7 = ConvertHexaToDecimal(binVal);
				num5 += num7;
				num7 = num5;
				string text7 = StringType.FromLong(num5);
				text = StringType.FromDouble(DoubleType.FromString(text) + 32.0);
				text4 = text4 + text7 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 6);
				float num8 = ConvertHexaToDecimal(binVal);
				num8 = (float)((double)num8 / 0.27777);
				num8 = SingleType.FromString(Strings.Format((object)num8, "0.00"));
				string text8 = StringType.FromSingle(num8);
				int num9 = Strings.Len(text8);
				string text9 = "";
				int num10 = num9;
				for (int i = 1; i <= num10; i++)
				{
					char c2 = CharType.FromString(Strings.Mid(text8, i, 1));
					text9 = ((StringType.StrCmp(StringType.FromChar(c2), ",", false) != 0) ? (text9 + StringType.FromChar(c2)) : (text9 + "."));
				}
				text = StringType.FromDouble(DoubleType.FromString(text) + 6.0);
				text4 = text4 + text9 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 16);
				num = ConvertHexaToDecimal(binVal);
				string text10 = StringType.FromLong(num);
				text = StringType.FromDouble(DoubleType.FromString(text) + 16.0);
				text4 = text4 + text10 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 8);
				string text11 = ConversionBinToHex(binVal);
				text = StringType.FromDouble(DoubleType.FromString(text) + 8.0);
				text4 = text4 + "0X" + text11 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 1);
				char c3 = CharType.FromString(binVal);
				text = StringType.FromDouble(DoubleType.FromString(text) + 1.0);
				text4 = text4 + StringType.FromChar(c3) + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 1);
				char c4 = CharType.FromString(binVal);
				text = StringType.FromDouble(DoubleType.FromString(text) + 1.0);
				text4 = text4 + StringType.FromChar(c4) + ", ";
				text4 += StringType.FromInteger(NumeroTrama);
				GuardarArchivoTexto(text4);
				int num11 = num2 - 1;
				for (int j = 1; j <= num11; j++)
				{
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 12);
					num5 = ((StringType.StrCmp(Strings.Mid(binVal, 1, 1), "0", false) != 0) ? (-2048L) : 0L);
					binVal = Strings.Right(binVal, Strings.Len(binVal) - 1);
					num = ConvertHexaToDecimal(binVal);
					num5 += num;
					num4 += num5;
					long numeroSegundosAno2 = num4;
					Segundo = StringType.FromObject(obj);
					Minuto = StringType.FromObject(obj2);
					Hora = StringType.FromObject(obj3);
					Dia = StringType.FromObject(obj4);
					Mes = StringType.FromObject(obj5);
					ObtenerFecha(numeroSegundosAno2, ref Segundo, ref Minuto, ref Hora, ref Dia, ref Mes);
					obj5 = Mes;
					obj4 = Dia;
					obj3 = Hora;
					obj2 = Minuto;
					obj = Segundo;
					text = StringType.FromDouble(DoubleType.FromString(text) + 12.0);
					text4 = StringType.FromObject(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(obj2, (object)"/"), obj), (object)"/"), (object)text3), (object)", "), obj3), (object)":"), obj4), (object)":"), obj5), (object)", "));
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 4);
					num = ConvertHexaToDecimal(binVal);
					text5 = StringType.FromLong(num);
					text = StringType.FromDouble(DoubleType.FromString(text) + 4.0);
					text4 = text4 + text5 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 1);
					c = CharType.FromString(binVal);
					text = StringType.FromDouble(DoubleType.FromString(text) + 1.0);
					text4 = text4 + StringType.FromChar(c) + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 18);
					num5 = ((StringType.StrCmp(Strings.Mid(binVal, 1, 1), "0", false) != 0) ? (-131072L) : 0L);
					binVal = Strings.Right(binVal, Strings.Len(binVal) - 1);
					num = ConvertHexaToDecimal(binVal);
					num5 += num;
					num6 += num5;
					text6 = StringType.FromLong(num6);
					text = StringType.FromDouble(DoubleType.FromString(text) + 18.0);
					text4 = text4 + text6 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 18);
					num5 = ((StringType.StrCmp(Strings.Mid(binVal, 1, 1), "0", false) != 0) ? (-131072L) : 0L);
					binVal = Strings.Right(binVal, Strings.Len(binVal) - 1);
					num = ConvertHexaToDecimal(binVal);
					num5 += num;
					num7 += num5;
					text7 = StringType.FromLong(num7);
					text = StringType.FromDouble(DoubleType.FromString(text) + 18.0);
					text4 = text4 + text7 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 6);
					num8 = ConvertHexaToDecimal(binVal);
					num8 = (float)((double)num8 / 0.27777);
					num8 = SingleType.FromString(Strings.Format((object)num8, "0.00"));
					text8 = StringType.FromSingle(num8);
					num9 = Strings.Len(text8);
					text9 = "";
					int num12 = num9;
					for (int i = 1; i <= num12; i++)
					{
						char c2 = CharType.FromString(Strings.Mid(text8, i, 1));
						text9 = ((StringType.StrCmp(StringType.FromChar(c2), ",", false) != 0) ? (text9 + StringType.FromChar(c2)) : (text9 + "."));
					}
					text = StringType.FromDouble(DoubleType.FromString(text) + 6.0);
					text4 = text4 + text9 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 10);
					num = ConvertHexaToDecimal(binVal);
					text10 = StringType.FromLong(num);
					text = StringType.FromDouble(DoubleType.FromString(text) + 10.0);
					text4 = text4 + text10 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 8);
					text11 = ConversionBinToHex(binVal);
					text = StringType.FromDouble(DoubleType.FromString(text) + 8.0);
					text4 = text4 + "0X" + text11 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 1);
					c3 = CharType.FromString(binVal);
					text = StringType.FromDouble(DoubleType.FromString(text) + 1.0);
					text4 = text4 + StringType.FromChar(c3) + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 1);
					c4 = CharType.FromString(binVal);
					text = StringType.FromDouble(DoubleType.FromString(text) + 1.0);
					text4 = text4 + StringType.FromChar(c4) + ", ";
					text4 += StringType.FromInteger(NumeroTrama);
					GuardarArchivoTexto(text4);
				}
			}
			catch (Exception ex)
			{
				ProjectData.SetProjectError(ex);
				Exception ex2 = ex;
				Interaction.MsgBox((object)("Error Aplicación Nº 2. " + ex2.ToString()), (MsgBoxStyle)16, (object)"HISTORICO");
				ProjectData.ClearProjectError();
			}
		}
	}

	private void TratarHistoricoNuevo(string CadenaTrama, int NumeroTrama)
	{
		//IL_0a4b: Unknown result type (might be due to invalid IL or missing references)
		checked
		{
			try
			{
				string text = StringType.FromInteger(1);
				string text2 = ConversionHexToBin(CadenaTrama);
				string binVal = Strings.Mid(text2, IntegerType.FromString(text), 8);
				long num = ConvertHexaToDecimal(binVal);
				int num2 = (int)num;
				text = StringType.FromDouble(DoubleType.FromString(text) + 8.0);
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 6);
				long num3 = ConvertHexaToDecimal(binVal);
				string text3 = StringType.FromDouble(DoubleType.FromString(StringType.FromLong(num3)) + 1980.0);
				text = StringType.FromDouble(DoubleType.FromString(text) + 6.0);
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 25);
				long num4 = ConvertHexaToDecimal(binVal);
				long numeroSegundosAno = num4;
				object obj = default(object);
				string Mes = StringType.FromObject(obj);
				object obj2 = default(object);
				string Dia = StringType.FromObject(obj2);
				object obj3 = default(object);
				string Hora = StringType.FromObject(obj3);
				object obj4 = default(object);
				string Minuto = StringType.FromObject(obj4);
				object obj5 = default(object);
				string Segundo = StringType.FromObject(obj5);
				ObtenerFecha(numeroSegundosAno, ref Mes, ref Dia, ref Hora, ref Minuto, ref Segundo);
				obj5 = Segundo;
				obj4 = Minuto;
				obj3 = Hora;
				obj2 = Dia;
				obj = Mes;
				text = StringType.FromDouble(DoubleType.FromString(text) + 25.0);
				string text4 = StringType.FromObject(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj((object)text4, obj2), (object)"/"), obj), (object)"/"), (object)text3), (object)", "), obj3), (object)":"), obj4), (object)":"), obj5), (object)", "));
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 6);
				num = ConvertHexaToDecimal(binVal);
				string text5 = StringType.FromLong(num);
				text = StringType.FromDouble(DoubleType.FromString(text) + 6.0);
				text4 = text4 + text5 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 1);
				char c = CharType.FromString(binVal);
				text = StringType.FromDouble(DoubleType.FromString(text) + 1.0);
				text4 = text4 + StringType.FromChar(c) + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 32);
				long num5 = ((StringType.StrCmp(Strings.Mid(binVal, 1, 1), "0", false) != 0) ? (-2147483648L) : 0L);
				binVal = Strings.Right(binVal, Strings.Len(binVal) - 1);
				long num6 = ConvertHexaToDecimal(binVal);
				num5 += num6;
				num6 = num5;
				string text6 = StringType.FromLong(num5);
				text = StringType.FromDouble(DoubleType.FromString(text) + 32.0);
				text4 = text4 + text6 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 32);
				num5 = ((StringType.StrCmp(Strings.Mid(binVal, 1, 1), "0", false) != 0) ? (-2147483648L) : 0L);
				binVal = Strings.Right(binVal, Strings.Len(binVal) - 1);
				long num7 = ConvertHexaToDecimal(binVal);
				num5 += num7;
				num7 = num5;
				string text7 = StringType.FromLong(num5);
				text = StringType.FromDouble(DoubleType.FromString(text) + 32.0);
				text4 = text4 + text7 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 6);
				float num8 = ConvertHexaToDecimal(binVal);
				num8 = (float)((double)num8 / 0.27777);
				num8 = SingleType.FromString(Strings.Format((object)num8, "0.00"));
				string text8 = StringType.FromSingle(num8);
				int num9 = Strings.Len(text8);
				string text9 = "";
				int num10 = num9;
				for (int i = 1; i <= num10; i++)
				{
					char c2 = CharType.FromString(Strings.Mid(text8, i, 1));
					text9 = ((StringType.StrCmp(StringType.FromChar(c2), ",", false) != 0) ? (text9 + StringType.FromChar(c2)) : (text9 + "."));
				}
				text = StringType.FromDouble(DoubleType.FromString(text) + 6.0);
				text4 = text4 + text9 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 20);
				num = ConvertHexaToDecimal(binVal);
				string text10 = StringType.FromLong(num);
				text = StringType.FromDouble(DoubleType.FromString(text) + 20.0);
				text4 = text4 + text10 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 8);
				string text11 = ConversionBinToHex(binVal);
				text = StringType.FromDouble(DoubleType.FromString(text) + 8.0);
				text4 = text4 + "0X" + text11 + ", ";
				binVal = Strings.Mid(text2, IntegerType.FromString(text), 1);
				char c3 = CharType.FromString(binVal);
				text = StringType.FromDouble(DoubleType.FromString(text) + 1.0);
				text4 = text4 + StringType.FromChar(c3) + ", ";
				text4 += StringType.FromInteger(NumeroTrama);
				GuardarArchivoTexto(text4);
				int num11 = num2 - 1;
				for (int j = 1; j <= num11; j++)
				{
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 12);
					num5 = ((StringType.StrCmp(Strings.Mid(binVal, 1, 1), "0", false) != 0) ? (-2048L) : 0L);
					binVal = Strings.Right(binVal, Strings.Len(binVal) - 1);
					num = ConvertHexaToDecimal(binVal);
					num5 += num;
					num4 += num5;
					long numeroSegundosAno2 = num4;
					Segundo = StringType.FromObject(obj);
					Minuto = StringType.FromObject(obj2);
					Hora = StringType.FromObject(obj3);
					Dia = StringType.FromObject(obj4);
					Mes = StringType.FromObject(obj5);
					ObtenerFecha(numeroSegundosAno2, ref Segundo, ref Minuto, ref Hora, ref Dia, ref Mes);
					obj5 = Mes;
					obj4 = Dia;
					obj3 = Hora;
					obj2 = Minuto;
					obj = Segundo;
					text = StringType.FromDouble(DoubleType.FromString(text) + 12.0);
					text4 = StringType.FromObject(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(ObjectType.StrCatObj(obj2, (object)"/"), obj), (object)"/"), (object)text3), (object)", "), obj3), (object)":"), obj4), (object)":"), obj5), (object)", "));
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 6);
					num = ConvertHexaToDecimal(binVal);
					text5 = StringType.FromLong(num);
					text = StringType.FromDouble(DoubleType.FromString(text) + 6.0);
					text4 = text4 + text5 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 1);
					c = CharType.FromString(binVal);
					text = StringType.FromDouble(DoubleType.FromString(text) + 1.0);
					text4 = text4 + StringType.FromChar(c) + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 18);
					num5 = ((StringType.StrCmp(Strings.Mid(binVal, 1, 1), "0", false) != 0) ? (-131072L) : 0L);
					binVal = Strings.Right(binVal, Strings.Len(binVal) - 1);
					num = ConvertHexaToDecimal(binVal);
					num5 += num;
					num6 += num5;
					text6 = StringType.FromLong(num6);
					text = StringType.FromDouble(DoubleType.FromString(text) + 18.0);
					text4 = text4 + text6 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 18);
					num5 = ((StringType.StrCmp(Strings.Mid(binVal, 1, 1), "0", false) != 0) ? (-131072L) : 0L);
					binVal = Strings.Right(binVal, Strings.Len(binVal) - 1);
					num = ConvertHexaToDecimal(binVal);
					num5 += num;
					num7 += num5;
					text7 = StringType.FromLong(num7);
					text = StringType.FromDouble(DoubleType.FromString(text) + 18.0);
					text4 = text4 + text7 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 6);
					num8 = ConvertHexaToDecimal(binVal);
					num8 = (float)((double)num8 / 0.27777);
					num8 = SingleType.FromString(Strings.Format((object)num8, "0.00"));
					text8 = StringType.FromSingle(num8);
					num9 = Strings.Len(text8);
					text9 = "";
					int num12 = num9;
					for (int i = 1; i <= num12; i++)
					{
						char c2 = CharType.FromString(Strings.Mid(text8, i, 1));
						text9 = ((StringType.StrCmp(StringType.FromChar(c2), ",", false) != 0) ? (text9 + StringType.FromChar(c2)) : (text9 + "."));
					}
					text = StringType.FromDouble(DoubleType.FromString(text) + 6.0);
					text4 = text4 + text9 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 13);
					num = ConvertHexaToDecimal(binVal);
					text10 = StringType.FromLong(num);
					text = StringType.FromDouble(DoubleType.FromString(text) + 13.0);
					text4 = text4 + text10 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 8);
					text11 = ConversionBinToHex(binVal);
					text = StringType.FromDouble(DoubleType.FromString(text) + 8.0);
					text4 = text4 + "0X" + text11 + ", ";
					binVal = Strings.Mid(text2, IntegerType.FromString(text), 1);
					c3 = CharType.FromString(binVal);
					text = StringType.FromDouble(DoubleType.FromString(text) + 1.0);
					text4 = text4 + StringType.FromChar(c3) + ", ";
					text4 += StringType.FromInteger(NumeroTrama);
					GuardarArchivoTexto(text4);
				}
			}
			catch (Exception ex)
			{
				ProjectData.SetProjectError(ex);
				Exception ex2 = ex;
				Interaction.MsgBox((object)("Error Aplicación Nº 9. " + ex2.ToString()), (MsgBoxStyle)16, (object)"HISTORICO");
				ProjectData.ClearProjectError();
			}
		}
	}

	private void ObtenerFecha(long NumeroSegundosAno, ref string Mes, ref string Dia, ref string Hora, ref string Minuto, ref string Segundo)
	{
		//IL_021f: Unknown result type (might be due to invalid IL or missing references)
		int[] array = new int[13];
		checked
		{
			try
			{
				array[1] = 31;
				if (true)
				{
					array[2] = 28;
				}
				else
				{
					array[2] = 30;
				}
				array[3] = 31;
				array[4] = 30;
				array[5] = 31;
				array[6] = 30;
				array[7] = 31;
				array[8] = 31;
				array[9] = 30;
				array[10] = 31;
				array[11] = 30;
				array[12] = 31;
				double num = (double)NumeroSegundosAno / 86400.0;
				double num2 = num - Conversion.Int(num);
				double num3 = num2 * 86400.0;
				num3 /= 60.0;
				num2 = num3 - Conversion.Int(num3);
				int num4 = (int)Math.Round(num2 * 60.0);
				int num5 = num4;
				int num6 = (int)Math.Round(Conversion.Int(num3));
				double num7 = (double)num6 / 60.0;
				num2 = num7 - Conversion.Int(num7);
				int num8 = (int)Math.Round(num2 * 60.0);
				int num9 = (int)Math.Round(Conversion.Int(num7));
				int num10 = 1;
				int num11 = (int)Math.Round(Conversion.Int(num));
				int num12 = 1;
				while (num11 > array[num12])
				{
					num11 -= array[num12];
					num10++;
					num12++;
					if (num12 > 12)
					{
						break;
					}
				}
				int num13 = num11 + 1;
				int num14 = num10;
				if (num14 < 10)
				{
					Mes = "0" + StringType.FromInteger(num14);
				}
				else
				{
					Mes = StringType.FromInteger(num14);
				}
				if (num13 < 10)
				{
					Dia = "0" + StringType.FromInteger(num13);
				}
				else
				{
					Dia = StringType.FromInteger(num13);
				}
				if (num9 < 10)
				{
					Hora = "0" + StringType.FromInteger(num9);
				}
				else
				{
					Hora = StringType.FromInteger(num9);
				}
				if (num8 < 10)
				{
					Minuto = "0" + StringType.FromInteger(num8);
				}
				else
				{
					Minuto = StringType.FromInteger(num8);
				}
				if (num5 < 10)
				{
					Segundo = "0" + StringType.FromInteger(num5);
				}
				else
				{
					Segundo = StringType.FromInteger(num5);
				}
			}
			catch (Exception ex)
			{
				ProjectData.SetProjectError(ex);
				Exception ex2 = ex;
				Interaction.MsgBox((object)("Error Aplicación Nº 8. " + ex2.ToString()), (MsgBoxStyle)16, (object)"HISTORICO");
				ProjectData.ClearProjectError();
			}
		}
	}

	private long ConvertHexaToDecimal(string BinVal)
	{
		//IL_00a0: Unknown result type (might be due to invalid IL or missing references)
		checked
		{
			long result = default(long);
			try
			{
				long num = 0L;
				long num2 = Strings.Len(BinVal);
				long num3 = num2;
				for (long num4 = 1L; num4 <= num3; num4++)
				{
					int num5 = IntegerType.FromString(Strings.Mid(BinVal, (int)(num2 - (num4 - 1L)), 1));
					num = (long)Math.Round((double)num + (double)num5 * Math.Pow(2.0, num4 - 1L));
				}
				result = num;
				return result;
			}
			catch (Exception ex)
			{
				ProjectData.SetProjectError(ex);
				Exception ex2 = ex;
				Interaction.MsgBox((object)("Error Aplicación Nº 3. " + ex2.ToString()), (MsgBoxStyle)16, (object)"HISTORICO");
				ProjectData.ClearProjectError();
			}
			return result;
		}
	}

	private string ConversionHexToBin(string HistoricoHex)
	{
		//IL_02d2: Unknown result type (might be due to invalid IL or missing references)
		checked
		{
			string result = default(string);
			try
			{
				int num = 1;
				int num2 = Strings.Len(HistoricoHex) - 1;
				string text3 = default(string);
				for (int i = 0; i <= num2; i++)
				{
					string text = Strings.Mid(HistoricoHex, num, 1);
					string text2 = text;
					if (StringType.StrCmp(text2, "0", false) == 0)
					{
						text3 += "0000";
					}
					else if (StringType.StrCmp(text2, "1", false) == 0)
					{
						text3 += "0001";
					}
					else if (StringType.StrCmp(text2, "2", false) == 0)
					{
						text3 += "0010";
					}
					else if (StringType.StrCmp(text2, "3", false) == 0)
					{
						text3 += "0011";
					}
					else if (StringType.StrCmp(text2, "4", false) == 0)
					{
						text3 += "0100";
					}
					else if (StringType.StrCmp(text2, "5", false) == 0)
					{
						text3 += "0101";
					}
					else if (StringType.StrCmp(text2, "6", false) == 0)
					{
						text3 += "0110";
					}
					else if (StringType.StrCmp(text2, "7", false) == 0)
					{
						text3 += "0111";
					}
					else if (StringType.StrCmp(text2, "8", false) == 0)
					{
						text3 += "1000";
					}
					else if (StringType.StrCmp(text2, "9", false) == 0)
					{
						text3 += "1001";
					}
					else if (StringType.StrCmp(text2, "A", false) == 0 || StringType.StrCmp(text2, "a", false) == 0)
					{
						text3 += "1010";
					}
					else if (StringType.StrCmp(text2, "B", false) == 0 || StringType.StrCmp(text2, "b", false) == 0)
					{
						text3 += "1011";
					}
					else if (StringType.StrCmp(text2, "C", false) == 0 || StringType.StrCmp(text2, "c", false) == 0)
					{
						text3 += "1100";
					}
					else if (StringType.StrCmp(text2, "D", false) == 0 || StringType.StrCmp(text2, "d", false) == 0)
					{
						text3 += "1101";
					}
					else if (StringType.StrCmp(text2, "E", false) == 0 || StringType.StrCmp(text2, "e", false) == 0)
					{
						text3 += "1110";
					}
					else if (StringType.StrCmp(text2, "F", false) == 0 || StringType.StrCmp(text2, "f", false) == 0)
					{
						text3 += "1111";
					}
					num++;
				}
				result = text3;
				return result;
			}
			catch (Exception ex)
			{
				ProjectData.SetProjectError(ex);
				Exception ex2 = ex;
				Interaction.MsgBox((object)("Error Aplicación Nº 4. " + ex2.ToString()), (MsgBoxStyle)16, (object)"HISTORICO");
				ProjectData.ClearProjectError();
			}
			return result;
		}
	}

	private string ConversionBinToHex(string Cadenabits)
	{
		//IL_02a6: Unknown result type (might be due to invalid IL or missing references)
		checked
		{
			string result = default(string);
			try
			{
				int num = (int)Math.Round((double)Strings.Len(Cadenabits) / 4.0);
				string text = "";
				int num2 = 1;
				int num3 = num;
				for (int i = 1; i <= num3; i++)
				{
					string text2 = Strings.Mid(Cadenabits, num2, 4);
					string text3 = text2;
					if (StringType.StrCmp(text3, "0000", false) == 0)
					{
						text += "0";
					}
					else if (StringType.StrCmp(text3, "0001", false) == 0)
					{
						text += "1";
					}
					else if (StringType.StrCmp(text3, "0010", false) == 0)
					{
						text += "2";
					}
					else if (StringType.StrCmp(text3, "0011", false) == 0)
					{
						text += "3";
					}
					else if (StringType.StrCmp(text3, "0100", false) == 0)
					{
						text += "4";
					}
					else if (StringType.StrCmp(text3, "0101", false) == 0)
					{
						text += "5";
					}
					else if (StringType.StrCmp(text3, "0110", false) == 0)
					{
						text += "6";
					}
					else if (StringType.StrCmp(text3, "0111", false) == 0)
					{
						text += "7";
					}
					else if (StringType.StrCmp(text3, "1000", false) == 0)
					{
						text += "8";
					}
					else if (StringType.StrCmp(text3, "1001", false) == 0)
					{
						text += "9";
					}
					else if (StringType.StrCmp(text3, "1010", false) == 0)
					{
						text += "A";
					}
					else if (StringType.StrCmp(text3, "1011", false) == 0)
					{
						text += "B";
					}
					else if (StringType.StrCmp(text3, "1100", false) == 0)
					{
						text += "C";
					}
					else if (StringType.StrCmp(text3, "1101", false) == 0)
					{
						text += "D";
					}
					else if (StringType.StrCmp(text3, "1110", false) == 0)
					{
						text += "E";
					}
					else if (StringType.StrCmp(text3, "1111", false) == 0)
					{
						text += "F";
					}
					num2 += 4;
				}
				result = text;
				return result;
			}
			catch (Exception ex)
			{
				ProjectData.SetProjectError(ex);
				Exception ex2 = ex;
				Interaction.MsgBox((object)("Error Aplicación Nº 5. " + ex2.ToString()), (MsgBoxStyle)16, (object)"HISTORICO");
				ProjectData.ClearProjectError();
			}
			return result;
		}
	}

	private void GuardarArchivoTexto(string Cadenabin)
	{
		//IL_00bb: Unknown result type (might be due to invalid IL or missing references)
		string text = null;
		Stream stream = null;
		StreamWriter streamWriter = null;
		string text2 = null;
		try
		{
			if (!Directory.Exists("C:\\Historicos"))
			{
				Directory.CreateDirectory("C:\\Historicos");
			}
			Cursor.Current = Cursors.WaitCursor;
			string path = "C:\\Historicos\\Historico " + Strings.Format((object)DateAndTime.Today.Date, "ddMMyyyy") + ".txt";
			stream = ((!File.Exists(path)) ? File.Create(path) : File.Open(path, FileMode.Append));
			streamWriter = new StreamWriter(stream, Encoding.Default);
			streamWriter.WriteLine(Cadenabin);
			streamWriter.Close();
		}
		catch (Exception ex)
		{
			ProjectData.SetProjectError(ex);
			Exception ex2 = ex;
			Interaction.MsgBox((object)("Error Aplicación Nº 6. Error al Guardar la informacion en el archivo. " + ex2.ToString()), (MsgBoxStyle)16, (object)Application.ProductName);
			streamWriter.Close();
			ProjectData.ClearProjectError();
		}
	}
}
