package com.DE.Bots.Api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DE.Bots.Repository.BidDetailsRepo;
import com.DE.Bots.core.Model.BidDetails;

@RestController
public class BidController {

	@Autowired
	BidDetailsRepo bidRepo;

	@RequestMapping(value = "/saveBid", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public String saveBook(@RequestBody BidDetails bid) {
		bid.setBidDate(new Date().getTime());
		bidRepo.save(bid);
		return "Bidded Sucessfully!!";
	}

	@RequestMapping(value = "/getAllBid", produces = "application/json", method = RequestMethod.GET)
	public Iterable<BidDetails> getAll() {
		return bidRepo.findAll();
	}

	@RequestMapping(value = "/findcName", produces = "application/json", method = RequestMethod.GET)
	public List<BidDetails> getByCName(@RequestParam("cName") String cName) {
		return bidRepo.findByCName(cName);
	}
	/*
	 * @RequestMapping(value = "/findMinPrice", produces = "application/json",
	 * method = RequestMethod.GET) public List<BidDetails>
	 * getByMinPrice(@RequestParam("minPrice") double minPrice) {
	 * 
	 * return bidRepo.findByMinPrice(minPrice); }
	 */

	/*
	 * @RequestMapping(value = "/bidRead", produces = "application/json", method
	 * = RequestMethod.GET) public void readFile() throws IOException {
	 * List<BidDetails> bidList = new ArrayList<>(); BidDetails bidDetails =
	 * null;
	 * 
	 * String dwnldFolder = System.getProperty("user.dir"); dwnldFolder =
	 * dwnldFolder + "\\Book1.xlsx"; System.out.println(dwnldFolder); File
	 * myFile = new File(dwnldFolder); FileInputStream fis = new
	 * FileInputStream(myFile);
	 * 
	 * // Finds the workbook instance for XLSX file XSSFWorkbook myWorkBook =
	 * new XSSFWorkbook(fis);
	 * 
	 * // Return first sheet from the XLSX workbook XSSFSheet mySheet =
	 * myWorkBook.getSheetAt(0); System.out.println(mySheet.getFirstRowNum());
	 * // Get iterator to all the rows in current sheet Iterator<Row>
	 * rowIterator = mySheet.iterator(); int rowcount = 0; // Traversing over
	 * each row of XLSX file while (rowIterator.hasNext()) {
	 * 
	 * bidDetails = new BidDetails(); Row row = rowIterator.next(); int
	 * cellCount = 0; // For each row, iterate through each columns
	 * Iterator<Cell> cellIterator = row.cellIterator(); while
	 * (cellIterator.hasNext()) { cellCount++; if (rowcount == 0) { rowcount++;
	 * break; } if (cellCount == 1)
	 * bidDetails.setcName(cellIterator.next().toString()); if (cellCount == 2)
	 * bidDetails.setMinPrice(cellIterator.next().getNumericCellValue()); if
	 * (cellCount == 3)
	 * bidDetails.setSellPrice(cellIterator.next().getNumericCellValue()); //
	 * System.out.println(cellIterator.next());
	 * 
	 * Cell cell = cellIterator.next(); bidDetails.setcName(cName); switch
	 * (cell.getCellType()) { case Cell.CELL_TYPE_STRING:
	 * System.out.print(cell.getStringCellValue() + "\t"); break; case
	 * Cell.CELL_TYPE_NUMERIC: System.out.print(cell.getNumericCellValue() +
	 * "\t"); break; case Cell.CELL_TYPE_BOOLEAN:
	 * System.out.print(cell.getBooleanCellValue() + "\t"); break; default:
	 * 
	 * } } if (!(bidDetails.getcName() == null)) bidList.add(bidDetails);
	 * System.out.println(""); } bidRepo.save(bidList); }
	 */
}
