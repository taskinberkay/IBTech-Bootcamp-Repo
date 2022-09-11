package HW_03_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ConsoleApplication {
	private static Scanner scanner = new Scanner(System.in);
	private static String path = "..\\..\\IO\\ConsoleApp\\Supplier.txt";
	private static List<Supplier> supplierList = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		while (true) {
			printMenu();
			int choice = scanChoice();
			switch (choice) {
			case 1:
				doLoad();
				break;
			case 2:
				doStore();
				break;
			case 3:
				doList();
				break;
			case 4:
				doFind();
				break;
			case 5:
				doAdd();
				break;
			case 6:
				doUpdate();
				break;
			case 7:
				doDelete();
				break;
			case 0:
				doExit();
			default:
				System.out.println("Geçersiz Seçim !!!");
			}
		}

	}

	private static void printMenu() {
		System.out.println("Menü");
		System.out.println("1. Yükle");
		System.out.println("2. Sakla");
		System.out.println("3. Dizelgele");
		System.out.println("4. Bul");
		System.out.println("5. Ekle");
		System.out.println("6. Güncelle");
		System.out.println("7. Sil");
		System.out.println("0. Çık");
	}

	private static int scanChoice() {
		System.out.println("Seçiminiz ?");
		int choice = scanner.nextInt();
		return choice;
	}

	private static void doExit() {
		System.exit(0);
	}

	private static void doLoad() throws Exception {
		System.out.println("Yükleniyor...");
		SupplierFiler supplierFiler = new SupplierFiler(path);
		supplierList = supplierFiler.load();
	}

	private static void doStore() throws Exception {
		System.out.println("Saklanıyor...");
		SupplierFiler supplierFiler = new SupplierFiler(path);
		supplierFiler.store(supplierList);
	}

	private static void doList() {
		System.out.println("Dizelgeleniyor...");
		printList(supplierList);
	}

	private static void doFind() {
		System.out.println("Bulunuyor...");
		System.out.println("Aranan tedarikçinin ID'sini giriniz.");
		Supplier supplier = findSupplier(scanner.nextLong());
		if(supplier!=null) {
			printSupplier(supplier);
		}
	}

	private static void doAdd() {
		System.out.println("Ekleniyor...");
		if(supplierList == null) {
			System.out.println("Ekleme yapmak için listeyi yükleyiniz!");
			return;
		}else {
			supplierList.add(createSupplier());
		}
		
		
	}

	private static void doUpdate() {
		if(supplierList == null) {
			System.out.println("Arama yapmak için önce listeyi yükleyiniz!");
			return;
		}
		System.out.println("Güncelleniyor...");
		System.out.println("Güncellenecek tedarikçinin ID'sini giriniz");
		Supplier supplier = findSupplier(scanner.nextLong());
		if(supplier == null) {
			return;
		}
		deleteSupplier(supplier.getSupplierId());
		System.out.println("Güncel tedarikçi ismini giriniz.");
		supplier.setSupplierName(scanner.next());
		System.out.println("Güncel total krediyi giriniz.");
		supplier.setTotalCredit(scanner.nextDouble());
		supplierList.add(supplier);
	}

	private static void doDelete() {
		System.out.println("Siliniyor...");
		System.out.println("Silinecek tedarikçinin ID'sini giriniz.");
		deleteSupplier(scanner.nextLong());
	}

	private static Supplier createSupplier() {
		Supplier supplier = new Supplier();
		System.out.println("Tedarikçi ID'sini giriniz.");
		supplier.setSupplierId(scanner.nextLong());
		System.out.println("Tedarikçi ismini giriniz.");
		supplier.setSupplierName(scanner.next());
		System.out.println("Tedarikçi toplam kredisini giriniz");
		supplier.setTotalCredit(scanner.nextDouble());
		return supplier;
	}

	private static void printList(List<Supplier> supplierList) {
		for (Supplier supplier : supplierList) {
			printSupplier(supplier);
		}
	}

	private static void printSupplier(Supplier supplier) {
		System.out.println(
				supplier.getSupplierId() + "; " + supplier.getSupplierName() + "; " + supplier.getTotalCredit());
	}

	private static Supplier findSupplier(long id) {
		for (Supplier supplier : supplierList) {
			if (supplier.getSupplierId() == id) {
				System.out.println("Bulundu!");
				return supplier;
			}
		}
		System.out.println("Örtüşen sonuç bulunamadı!");
		return null;
	}
	
	private static void deleteSupplier(long id) {
		supplierList = supplierList.stream().filter(s -> s.getSupplierId() != id).collect(Collectors.toCollection(ArrayList::new));
	}
	
}
