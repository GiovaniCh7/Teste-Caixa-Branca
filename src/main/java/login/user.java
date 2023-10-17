package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    /** Metodo representando os funcionarios e suas interações com o banco de dados.
     **/
public class user {
    
    /** Metodo executado para conexão com o banco de dados
     * @return null caso a conexão falhe ou retorna a conexão estabelecida
     */
    public Connection conectarBD(){
       Connection conn = null;
 
        try{
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql//127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        }catch(Exception e) { }
       
        return conn;}
    /** Variaveis nome do usuario e verificação**/
    public String nome="";
    public boolean result = false;
    /** Verifica o usuario no banco de dados atraves dos dados fornecidos.
     * @param login nome usada pelo usuario.
     * @param senha senha usada pelo usuario.
     * @return true se o usuario existir e false caso não exista.
     */
    public boolean verificarUsuario(String login, String senha) throws SQLException {
        String sql="";
        Connection conn = conectarBD();
        
        //INSTRUÇÃO SQL
        sql += "select nome from usuários";
        sql += "where login  = " + "'" +login+"'";
        sql += "and senha  = " + "'" +senha+"';";
            Statement st= conn.createStatement();
        try{
            ResultSet rs = st.executeQuery(sql);
            /** Faz a consulta no SQL**/    
            if(rs.next()){
           
                result=true;
      
                nome = rs.getString("nome");}
        }catch(Exception e){ }
        return result; }
    }//fim da class