package predicates;

import com.awl.training.beans.Product;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

/**
 * The Class ProductIdPredicate is an implemntation of Predicate.
 */
public class ProductIdPredicate implements Predicate<Product> {

	private long productId;

	public ProductIdPredicate(long productId) {
		this.productId = productId;
	}

	@Override
	public boolean apply(Product product) {
		Preconditions.checkNotNull(product);

		return productId == product.getId();
	}

}
