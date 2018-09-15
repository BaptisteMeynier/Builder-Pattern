package com.java.design.pattern.builder.stepbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * 
 *                                                                        .................           
 *                                                                        .................           
 *                                                              --------->.....Build().....<-------- 
 *                                                             |          .................         | 
 *                                                             |          .................         | 
 *                                                             |                  ^                 |                                                          
 *                                                             |                  |                 |                                                              
 *                                                             |                  |                 | 
 *  .............    .............    ..............    ..............   .................          |
 *  .............    .............    ..............    ..............   .................          |
 *  ....FROM.....--->.....TO......--->....SUBJECT...--->...CONTENT....-->.......BCC.......          |
 *  .............    .............    ..............    ..............   .................          |
 *  .............    .............    ..............    ..............   .................          | 
 *                                                             |                  ^                 |
 *                                                             |                  |                 |
 *                                                             |                  v                 | 
 *                                                             |           ................         | 
 *                                                             |           ................         | 
 *                                                              ---------->.......CC.......--------- 
 *                                                                         ................           
 *                                                                         ................            
 *
 * 
 * @author baptiste
 *
 */
public class EmailWithStepBuilder {
	private String from;
	private List<String> to;
	private List<String> cc;
	private List<String> bcc;
	private String subject;
	private String content;


	public static FromStep builder() {
		return new Builder();
	}

	public interface FromStep {
		ToStep from(String from);
	}

	public interface ToStep {
		SubjectStep to(String... from);
	}

	public interface SubjectStep {
		ContentStep subject(String subject);
	}

	public interface ContentStep {
		Build content(String content);
	}

	public interface Build {
		EmailWithStepBuilder build();
		Build cc(String... cc);
		Build bcc(String... bcc);
	}
	
	public static class Builder implements FromStep, ToStep, SubjectStep, ContentStep, Build {
        private String from;
        private List<String> to;
        private List<String> cc;
        private List<String> bcc;
        private String subject;
        private String content;

        @Override
        public EmailWithStepBuilder build() {
            return new EmailWithStepBuilder(this);
        }
        @Override
        public Build cc(String... cc) {
            Objects.requireNonNull(cc);
            this.cc = new ArrayList<String>(Arrays.asList(cc));
            return this;
        }
        @Override
        public Build bcc(String... bcc) {
            Objects.requireNonNull(bcc);
            this.bcc = new ArrayList<String>(Arrays.asList(bcc));
            return this;
        }
        @Override
        public Build content(String content) {
            Objects.requireNonNull(content);
            this.content = content;
            return this;
        }
        @Override
        public ContentStep subject(String subject) {
            Objects.requireNonNull(subject);
            this.subject = subject;
            return this;
        }
        @Override
        public SubjectStep to(String... to) {
            Objects.requireNonNull(to);
            this.to = new ArrayList<String>(Arrays.asList(to));
            return this;
        }
        @Override
        public ToStep from(String from) {
            Objects.requireNonNull(from);
            this.from = from;
            return this;
        }
    }
	private EmailWithStepBuilder(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
        this.subject = builder.subject;
        this.content = builder.content;
    }

    public String getFrom() {
        return from;
    }

    public List<String> getTo() {
        return to;
    }

    public List<String> getCc() {
        return cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}
