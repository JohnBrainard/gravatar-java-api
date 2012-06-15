package com.brainardphotography.gravatar.jsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.brainardphotography.gravatar.GravatarImageURL;
import com.brainardphotography.gravatar.GravatarRating;
import com.google.common.base.Splitter;

public class GravatarImageTag extends SimpleTagSupport {
	private String email;
	private Integer size;
	private String defaultImage;
	private Boolean forceDefault;
	private List<GravatarRating> ratings;

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}
	
	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}
	
	public void setForceDefault(Boolean forceDefault) {
		this.forceDefault = forceDefault;
	}
	
	public void setRating(String ratingList) {
		Iterable<String> ratings = Splitter.on(',')
				.trimResults()
				.omitEmptyStrings()
				.split(ratingList);
		
		this.ratings = new ArrayList<GravatarRating>();

		for (String rating : ratings) {
			this.ratings.add(GravatarRating.valueOf(rating.toUpperCase()));
		}
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment body = getJspBody();
		PageContext context = (PageContext) getJspContext();
		JspWriter out = context.getOut();

		GravatarImageURL url = new GravatarImageURL(this.email,
				this.size,
				this.defaultImage,
				this.forceDefault,
				this.ratings == null ? null : EnumSet.copyOf(this.ratings));

		if (body != null) {
			context.setAttribute("gravatar", url, PageContext.PAGE_SCOPE);
			
			body.invoke(out);
		}

		super.doTag();
	}
}
