package com.atb.web.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BarCodeGenerator {

	private static final Log LOG = LogFactory.getLog(BarCodeGenerator.class);

	/*public String generateBarCodeForAsset(AssetStickerDetails assetStickerDetails,String barcodePath) {
		Document document = null;
		PdfWriter writer = null;
		String assetNumber = "";
		String assetHttpPath = null;
		String fileName=null;
		try {
			
			if(!new File(barcodePath).mkdir()){
				LOG.error("fILE cREATED");
			}
			Barcode128 code128 = new Barcode128();
			code128.setBarHeight(400f); 
	        code128.setX(4f);
			code128.setGenerateChecksum(true);
			document = new Document(new Rectangle(PageSize.A4_LANDSCAPE.rotate()));
			assetHttpPath = barcodePath + assetStickerDetails.getAsset().getAssetNumber()+"_"+assetStickerDetails.getAsset().getCreatedDate().getTime()+ ".pdf"; 
			writer = PdfWriter.getInstance(document, new FileOutputStream(assetHttpPath));
			fileName =assetStickerDetails.getAsset().getAssetNumber()+"_"+assetStickerDetails.getAsset().getCreatedDate().getTime()+ ".pdf";
			document.open();

			document.add(new Paragraph("NSN Asset Management Oy"));
			document.add(new Paragraph(assetStickerDetails.getAsset().getAssetDescription()));

			assetNumber = getAssetNumberForBarcode(assetStickerDetails);

			code128.setCode(assetNumber);

			document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
			document.close();

		} catch (Exception e) {
			LOG.error("Exception occured while generating Bar Code for asset sticker", e);
		} finally {
			document.close();
			writer.close();
		}
		return fileName;

	}*/

	/*private String getAssetNumberForBarcode(AssetStickerDetails assetStickerDetails) {
		StringBuffer assetNumberSb = new StringBuffer();
		;
		assetNumberSb.append(assetStickerDetails.getAsset().getCompanyCode());
		assetNumberSb.append("-");
		assetNumberSb.append(assetStickerDetails.getAsset().getAssetNumber());
		assetNumberSb.append("-");
		assetNumberSb.append(assetStickerDetails.getAsset().getSubAssetNumber() != null ? assetStickerDetails.getAsset().getSubAssetNumber():0);

		return assetNumberSb.toString();
	}*/
	
}
