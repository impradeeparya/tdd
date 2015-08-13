package in.helloroomie.dto.ad;

import in.helloroomie.domain.ad.Ad;
import in.helloroomie.domain.ad.Image;

import java.util.ArrayList;
import java.util.List;

public class AdImageDto {

	Ad ad;
	List<Long> imageIds;

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	public List<Long> getImageIds() {
		return imageIds;
	}

	public void setImageIds(List<Long> imageIds) {
		this.imageIds = imageIds;
	}

	public Ad prepareAd() {

		List<Image> images = new ArrayList<Image>();

		for (Long id : this.imageIds) {
			Image image = new Image();
			image.setId(id);
			images.add(image);
		}
		if (images.size() > 0) {
			ad.setImage(images);
		}
		return this.ad;
	}
}
