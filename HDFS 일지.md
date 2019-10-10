메인 컴퓨터 : 70.12.60.97
가상 리눅스 : 70.12.60.96 (계정 : root, 111111)

#### 브릿지 만드려면

------

노트북 네트워크설정에서 전부 다 잘 설정해놓고

``` linux
vi /etc/sysconfig/network-scripts/ifcfg-en*
```

설정에서 호스트 컴퓨터(노트북)과 ip는 다르고 게이트웨이 전부 잘 설정해주어야함.

``` linux
systemctl restart network	//네트워크 다시시작
```



#### tomcat (port : 80)

------

설치경로 : /root/installfiles/tomcat
그러므로 war파일 넣을 때 저기에 넣어야함.

소프트링크를 만들어두었다.

```linux
tomcatstart -> tomcat 시작.
tomcatstop -> tomcat 중지.
```



#### MariaDB(mySQL) (port : 3306)

------

```linux
systemctl restart mysql
systemctl status mysql
chkconfig mysql on 				->  mysql 가동
```

```linux
mysql		-> 그냥 이러면 MariaDB 서버에 접속(관리자 비밀번호 설정을 안했기때문)
```

사용자 설정은 이 리눅스밖에 안됨. 
데이터베이스 아직 아무것도 안만듦.      p.567 참조.



#### Oracle Database Express 11g(port : 8080)

------

SYS 및 SYSTEM 사용자의 비밀번호 : 111111

```linux
/etc/init.d/oracle-xe start
					  stop
					  status		//시작, 중지, 상태확인
```

Workspace : DB
Username : DB
Password : DB



#### Hadoop(namenode port : 50070)

------

설치경로 : /etc/hadoop-1.2.1/bin

소프트링크를 만들어놓았다

``` linux
hadoopstart			-> hadoop 시작
hadoopstop			-> hadoop 스탑, 반드시 해주기.
```

