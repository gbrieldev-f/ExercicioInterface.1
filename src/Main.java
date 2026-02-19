import model.entities.Contract;
import model.services.ContractService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    Scanner sc = new Scanner(System.in);
    System.out.println("Entre os dados do contrato:");
    System.out.print("Numero: ");
    Integer num = sc.nextInt();
    System.out.print("Data (dd/MM/yyyy): ");
    LocalDate date = LocalDate.parse(sc.next(), dtf);
    System.out.print("Valor do contrato: ");
    Double totalValue = sc.nextDouble();

    Contract c =  new Contract(num, date, totalValue);
    System.out.print("Entre com o numero de parcelas:");
    Integer numPar = sc.nextInt();

    ContractService cSer = new ContractService();

    cSer.processContract(c, numPar);
    System.out.print("Parcelas: \n " + c.getInstallments().toString());




    sc.close();
    }

