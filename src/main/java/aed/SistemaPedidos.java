
import java.util.ArrayList;

public class SistemaPedidos {
    /*Completar con los atributos privados*/
    private ListaEnlazada<Pedido> ordenllegada;
    private ArrayList<Handle<Pedido>>ordenId;
    private  String mensajeLlegada;
    private String mensajeId;
    


    public SistemaPedidos(){
        ordenllegada = new ListaEnlazada<Pedido>();
        ordenId = new  ArrayList<Handle<Pedido>>();
    }

    public void agregarPedido(Pedido pedido){
        Handle<Pedido> handle = ordenllegada.agregarAtras(pedido);
        agregarOrdenado(handle);
        

      
    }

    private void agregarOrdenado(Handle<Pedido> p){
       int i = 0;
       while (i< ordenId.size()&&ordenId.get(i).valor().id()<p.valor().id()) {
        i++;
        
       }
       ordenId.add(i, p);
    }

    public Pedido proximoPedidoPorId(){
       Handle<Pedido> handle = ordenId.remove(0);
       Pedido pedidoaMostrar = handle.valor();
       handle.eliminar();
       return pedidoaMostrar;
       
    }

    public Pedido proximoPedidoPorLlegada(){
        Pedido pedidoproximo = ordenllegada.obtenerPrimero();
        for (int index = 0; index < ordenId.size(); index++) {
            if (ordenId.get(index).valor().id() == pedidoproximo.id()){
                Handle<Pedido> handleaEliminar = ordenId.remove(index);
                handleaEliminar.eliminar();
                break;

            }
        }
        
        return pedidoproximo;

    }

    private int busquedaBinariaIndice(ArrayList<Handle<Pedido>> ls, Pedido pedido){
        throw new UnsupportedOperationException("No implementado aún"); 
    }

    public Pedido pedidoMenorId(){
       return ordenId.get(0).valor();

    }

    public String obtenerPedidosEnOrdenDeLlegada(){
        mensajeLlegada = "[";
       
        for (int index = 0; index <ordenllegada.longitud(); index++) {
            if (index == ordenllegada.longitud()-1){
                mensajeLlegada+=ordenllegada.obtener(index);
            }else{
            mensajeLlegada+=ordenllegada.obtener(index)+", ";

            }


        }
        mensajeLlegada+="]";
        return mensajeLlegada;
    }

    public String obtenerPedidosOrdenadosPorId(){
        mensajeId = "[";
        for (int index = 0; index < ordenId.size(); index++) {
             if (index == ordenId.size()-1){
                mensajeId+=ordenId.get(index).valor();
            }else{
            mensajeId+=ordenId.get(index).valor()+", ";

            }
        }
        mensajeId+="]";
        return  mensajeId;
    }
}