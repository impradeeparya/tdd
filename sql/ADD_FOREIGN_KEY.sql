ALTER TABLE `helloroomie`.`ad_image` 
ADD CONSTRAINT `FK_IMAGE`
  FOREIGN KEY (`image_id`)
  REFERENCES `helloroomie`.`image` (`id`);