import java.net.*; 
import java.io.*; 
import java.lang.*;

public class SMSSend
{
	public static void main(String args[])
	{
		try
		{			
			// �]�w�ܼ�
			Socket		socket; 
			String		len; 
			InputStream	Is; 
			OutputStream	Os; 
			DataInputStream DIS; 
			PrintStream	PS; 

			String msg 	= "";
			String MSGData	= "";
			String GetData	= "";
			String MsgID	= "";
			
			// �]�w�Ѽ�
			String username = "";			// �b��
			String password = "";			// �K�X
			String type = "now";			// �o�e���A
			String mobile = "09xxxxxxxx";		// �q��
			String message = "²�T����";		// ²�T���e
			String encoding = "big5";		// ²�T���e�s�X
			String popup = "";			// �ϥ� POPUP ���
			String mo = "";				// �ϥ����V²�T
			String vldtime = "";			// ²�T���Ĵ���
			String dlvtime = "";			// �w���ɶ�

			int Num = 0;

			msg = "username="+username+"&password="+password+"&type="+type+"&encoding="+encoding+"&popup="+popup+"&mo="+mo+"&mobile="+mobile+"&message="+message+"&vldtime="+vldtime+"&dlvtime="+dlvtime;
			Num = msg.length();
			Message.getBytes("ISO-8859-1");
			Num = Num + Message.length();
			
			MSGData = MSGData+"POST /send.php HTTP/1.1\r\n";
			MSGData = MSGData+"Host: api.twsms.com\r\n";
			MSGData = MSGData+"Content-Length: "+Num+"\r\n";
			MSGData = MSGData+"Content-Type: application/x-www-form-urlencoded\r\n";
			MSGData = MSGData+"Connection: Close\r\n\r\n";
			MSGData = MSGData+msg+"\r\n";			

			// �}�l�e²�T���
			socket=new Socket("api.twsms.com",80); 

			//��o����socket����J/��X�y 
			Is=socket.getInputStream(); 
			Os=socket.getOutputStream(); 

			//�إ߼ƾڬy 
			DIS=new DataInputStream(Is); 
			PS=new PrintStream(Os); 

			PS.println(MSGData);

			int i=1;
			while(true){
				GetData = DIS.readLine();
				if (i == 10)
				{
					MsgID = GetData;
				}
				if (GetData == null)break;
				i++;
			}

			//�����s�� 
			DIS.close(); //�����ƾڿ�J�y 
			PS.close(); //�����ƾڿ�X�y 
			Is.close(); //������J�y 
			Os.close(); //������X�y 
			socket.close(); //����socket 
			
			// ���G��X
			System.out.println("�^�ǽX:" + MsgID);

		}
		catch(Exception e){ 
			System.out.println("�L�k�s�� TwSMS API Server!"); 
		} 
	}
}
