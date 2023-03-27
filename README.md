# GP_01
Object Oriented Programming /practical guide 01


A Listagem 1 exemplifica um programa "hello world"em JavaFX; as palavras reservadas estão a vermelho e as classes utilizadas a azul:
Listagem 1: Um programa "Hello World"
1 package pt . ipb ej a . h ell o . gui ;
3 import j a v a f x . applic a ti on . Applic a tion ;
import j a v a f x . geometry . Pos ;
5 import j a v a f x . scene . Scene ;
import j a v a f x . scene . con t rol . Label ;
7 import j a v a f x . s t a g e . S tage ;
9 pub l ic c l a s s Main extends Applic a tion {
@Override
11 pub l ic void s t a r t ( S tage primaryS tage ) {
Label h ello L ab el = new Label ( "Hello World!" ) ;
13 h ello L ab el . se tAlignmen t ( Pos .CENTER ) ;
Scene scene = new Scene ( h elloL ab el , 200 , 1 0 0 ) ;
15 primaryS tage . se tScene ( scene ) ;
primaryS tage . show ( ) ;
17 } // end s t a r t
19 pub l ic s t a t i c void main ( S t ri n g [ ] a r gs ) {
Applic a tion . launch ( a r gs ) ;
21 }
}
Eis o essencial para cria uma interface gráfica em JavaFX:
1. Na linha 20, ométodo static launch da classe Application. (Application.launch(args))
provoca a execução dométodo start (public void start (Stage primaryStage)).
2. Um Stage (palco) corresponde a uma janela na interface gráfica.
3. No método start, linha 11, o programa tem disponível um objecto do tipo
Stage que corresponde a um "palco" (janela) principal (primaryStage).
4. Cada cena é um objecto da classe Scene.
5. No palco pode estar uma cena (Scene): para tal enviamos uma cena para o
objeto palco: primaryStage.setScene(scene);.
6. Cada cena tem um nó "pai"(parent); no exemplo anterior é uma Label; o
texto na mesma é centrado pelo método na linha 13.
7. É o nó "pai" que nós vemos dentro da janela (Stage), a cena é invisível.
8. O palco (janela) deve ser colocado como visível: primaryStage.show()
9. Adição de comportamento — um handler para um
Button
Para que um botão (Button) faça algo, temos de lhe dizer o que queremos que
ele faça. Para tal, informamos o botão sobre qual a função que queremos que
seja executada quando o mesmo é premido. O código na Listagem 2 ilustra essa
possibilidade.
Listagem 2: Um programa com um botão e a função handler passada
num objeto de uma classe ButtonHandler que implementa a interface
EventHandler<ActionEvent>
2 package pt . ipb ej a . h ell o . gui ;
4 import j a v a f x . applic a ti on . Applic a tion ;
import j a v a f x . event . Ac tionEven t ;
6 import j a v a f x . event . EventHandler ;
import j a v a f x . scene . Scene ;
8 import j a v a f x . scene . con t rol . A l e r t ;
import j a v a f x . scene . con t rol . Button ;
10 import j a v a f x . s t a g e . S tage ;
12 pub l ic c l a s s Main extends Applic a tion {
@Override
14 pub l ic void s t a r t ( S tage primaryS tage ) {
Button button = new Button ( "Press me" ) ;
16 ButtonHandler buttonHandler = new ButtonHandler ( ) ;
button . setOnAction ( buttonHandler ) ;
18 Scene scene = new Scene ( button , 200 , 1 0 0 );
primaryS tage . se tScene ( scene ) ;
20 primaryS tage . show ( ) ;
}
22
c l a s s ButtonHandler implements EventHandler<ActionEvent> {
24 @Override
pub l ic void handle ( Ac tionEven t event ) {
26 A l e r t a l e r t = new A l e r t ( A l e r t . Ale r tType . INFORMATION, "Hello" ) ;
a l e r t . showAndWait ( ) ;
28 }
}
30
pub l ic s t a t i c void main ( S t ri n g [ ] a r gs ) {
32 Applic a tion . launch ( a r gs ) ;
}
34 }
Os detalhes são os seguintes:
1. Na verdade, a função que queremos que seja executada está dentro de um
objecto e é esse objecto que passamos para o botão;
2. O objecto que passamos, tem de ser de uma classe que é do tipo
EventHandler<ActionEvent>;
3. Para que uma classe seja desse tipo definimo-la como implementando esse
tipo. No nosso exemplo é a classe com o nome ButtonHandler (ver linha 23
da Listagem 2);
4. Temos então de criar um objecto dessa classe new ButtonHandler() (ver linha 16 da Listagem 2) e passar esse objecto para o botão utilizando o método button.setOnAction, tal como é feito na linha 17 da Listagem 2 .

  5. O código que queremos executar está na função handle (linha 29 da Listagem 2) na classe ButtonHandler.
6. As classes como a ButtonHandler — que servem para criar objectos que têm
um método que queremos que seja executado para tratar (handle) de um
evento — costumam ser definidas dentro da classe onde é criado o objecto
(o nosso Button) para o qual queremos definir o comportamento; a estas
classes chamamos inner classes. Portanto, na Listagem 2, a classe
ButtonHandler é uma inner classe (classe interna) da classe Main.
4 Exercícios Propostos
1. Coloque a funcionar o programa da Listagem 2).
2. Faça um novo programa com dois botões; estes dois botões devem fazer o
mesmo e para tal devem utilizar o mesmo objecto da classe ButtonHandler.
Na cena só podemos colocar um nó (Node) que na Listagem é um botão.
Como agora necessitamos de dois botões, vamos ter de colocar na cena um
novo tipo de nó. Vamos utiliza uma "caixa vertical" (VBox) e é nesse objecto que vamos colocar os dois botões. Depois colocamos o objecto vBox
na cena, como nó principal:
VBox vBox = new VBox ( ) ;
vBox . g e tChild r en ( ) . addAll ( button1 , button2 ) ;
Scene scene = new Scene ( vBox , 200 , 1 0 0 ) ;
Em rigor, adicionámos os botões à lista de "filhos" (children) do objecto
vBox.
3. Faça um novo programa com dois botões; agora quando prime um botão a
mensagem que surge deve indicar se foi premido o botão 1 ou 2. Para tal, o
método handle deve perguntar ao objecto event qual o objecto que originou
esse evento: no nosso exemplo foi de certeza um botão mas não sabemos
qual. O objecto event que é um parâmetro do método handle, tem o método getSource que devolve esse objecto. Note que deve fazer um cast para
o tipo que interessa: Button no nosso caso:
Button bu t tonClicked = ( Button ) ( event . ge tSource ( ) ) ;
4. Faça um novo programa com dois botões; estes dois botões devem mudar
o valor de duas Labels. Cada Label tem o valor zero no início e quando o
respetivo botão é premido essa Label incrementa o valor. Veja os métodos
getText() e setText da classe Label.
5 Informação adicional
O JavaFX tem imensas possibilidades suportadas por centenas de classes e milhares de métodos. As referências seguintes são uma ajuda importante para encontrar exemplos e consultar informação relevante para o que pretendemos fazer. Algum do código nas referências seguintes utiliza FXML, construtores de GUIs (GUI
builders) e/ou css. Pelo menos para já, não vamos utilizar nada disso.
• JavaFX: Working with JavaFX UI Components – Table of Contents: http://
docs.oracle.com/javase/8/javafx/user-interface-tutorial

  
