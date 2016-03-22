package br.com.akula.impl.file;

import java.io.IOException;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;

import br.com.akula.api.file.AkulaFileSystem;

public class AkulaFileSystemImpl implements AkulaFileSystem, ResourceLoaderAware{

	private ResourceLoader resourceLoader;
	
	@Override
	public String getResourceContent(String location) throws IOException {
		Resource res = resourceLoader.getResource(location);
		byte[] fileData = new byte[(int) res.contentLength()];
		res.getInputStream().read(fileData);
		String content = new String(fileData);
		
		return content;
	}

	@Override
	public Resource getResource(String location) {
		return resourceLoader.getResource(location);
	}

	@Override
	public Resource[] getResources(String location) throws IOException {
		return ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(location);
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
}